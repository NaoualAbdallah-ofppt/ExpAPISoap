package com.example.expapisoap;
public class Item {


    private String id;
        private String title;
        private String description;

        // Getters et setters
        public String getId() {
            return id;
        }

    public void setId(String id) {
        this.id = id;
    }
        public String getTitle() {
            return title;
        }
        public void setTitle(String title) {
            this.title = title;
        }
        public String getDescription() {
            return description;
        }
        public void setDescription(String description) {
            this.description = description;
        }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

