Dalbaeb


# SpringTutorial-28

**JDBC Template**


Обертка вокруг JDBC API, которая предоставляет Spring Framework

Грубо говоря он преобразует 20 строк написанных с помощью JDBC API в одну строчку написанную с использованием JDBC template

Пару примеров с использованием JDBC Template

-     public List<Person> index(){
        return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));


-     public Person show(int id) {

        return jdbcTemplate.query("SELECT * FROM Person WHERE id=?", new Object[]{id},new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny().orElse(null);

-     public void save(Person person){
        jdbcTemplate.update("INSERT INTO Person VALUES (1, ?, ?, ?)", person.getName(), person.getAge(), person.getEmail());
