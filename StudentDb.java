public class StudentDb {
    
        int Roll_No,Fees,RemainingFees,PaidFees;
        String Name,Father_Name,Course;
    
        void setName(String Name){
            this.Name=Name;
            
        }
        public String getName() {
            return Name;
        }
        void setFather_Name(String Father_Name){
            this.Father_Name=Father_Name;
        }
        public String getFather_Name() {
            return Father_Name;
        }
        void setCourse(String Course){
            this.Course=Course;
    
        }
        public String getCourse() {
            return Course;
        }
        void setRoll_No(int Roll_No){
            this.Roll_No=Roll_No;
        }
        int getRoll_No(){
            return Roll_No;
        }
        void setFees(int Fees){
            this.Fees=Fees;
        }
       int getFees(){
           return Fees;
       }
       void setRemainingFees(int RemainingFees ){
           this.RemainingFees=RemainingFees;
       }
       int getRemainingFees(){
           return RemainingFees;
       }
       void setPaidFees(int PaidFees){
         this.PaidFees=PaidFees;
    }
    int getPaidFees(){
       return PaidFees;
    }
    
    }
    
    

