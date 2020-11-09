package ru.nugmanov.DNugmanovTestReceiver.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.text.DateFormat;
import java.util.*;

/**
 * Сущность - Сообщение
 *
 * @author NugmanovDT, 05.11.2020
 */
@XmlRootElement(name = "account")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", nullable = false)
    private Long id;

    @XmlElement
    private long number;

    @XmlElement
    @Temporal(TemporalType.DATE)
    private Date date;

    @XmlElement
    private String text;

    @Transient
    private String dateStr;

    public Message() {
    }

    public Message(int number, Date date, String text) {
        this.number = number;
        this.date = date;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDateStr() {
        if (date != null) {
            return DateFormat.getDateInstance(DateFormat.SHORT).format(date);
        } else {
            return "";
        }
    }
}
