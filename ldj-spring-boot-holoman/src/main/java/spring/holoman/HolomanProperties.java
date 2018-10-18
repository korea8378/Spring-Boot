package spring.holoman;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("holoman")
//application.properties에서 설정이 가능하게 해준다.
public class HolomanProperties {
    String name;

    int howLong;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHowLong() {
        return howLong;
    }

    public void setHowLong(int howLong) {
        this.howLong = howLong;
    }

    @Override
    public String toString() {
        return "Holoman{" +
                "name='" + name + '\'' +
                ", howLong=" + howLong +
                '}';
    }
}
