package gson.model;


import java.util.List;


public class Training {
    private String name;
    private List<ModuleTraining> moduleTrainingList;

    public Training() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ModuleTraining> getModuleTrainingList() {
        return moduleTrainingList;
    }

    public void setModuleTrainingList(List<ModuleTraining> moduleTrainingList) {
        this.moduleTrainingList = moduleTrainingList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Training training = (Training) o;

        if (name != null ? !name.equals(training.name) : training.name != null) return false;
        return moduleTrainingList != null ? moduleTrainingList.equals(training.moduleTrainingList) : training.moduleTrainingList == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (moduleTrainingList != null ? moduleTrainingList.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Training{" +
                "name='" + name + '\'' +
                ", moduleTrainingList=" + moduleTrainingList +
                '}';
    }
}
