public  enum RecordType {
    PERSON{
        @Override
        public Record createRecord() {
            return new Person();
        }
    },
    TEXT{
        @Override
        public Record createRecord() {
            return new Text();
        }
    },
    ;

    public abstract Record createRecord();
}
