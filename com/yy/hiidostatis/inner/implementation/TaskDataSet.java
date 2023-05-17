package com.yy.hiidostatis.inner.implementation;

import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
/* loaded from: classes10.dex */
public class TaskDataSet implements Serializable {
    public static final Comparator<TaskData> DATA_COMPARATOR = new MyComparator();
    public static final long serialVersionUID = -8880276834197410994L;
    public Set<TaskData> dataSet = new TreeSet(DATA_COMPARATOR);

    /* loaded from: classes10.dex */
    public static final class MyComparator implements Comparator<TaskData>, Serializable {
        public static final long serialVersionUID = 605434724079570979L;

        public MyComparator() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        public int compare(TaskData taskData, TaskData taskData2) {
            if (taskData.equals(taskData2)) {
                return 0;
            }
            if (taskData.getOrder() > taskData2.getOrder()) {
                return 1;
            }
            if (taskData.getOrder() < taskData2.getOrder()) {
                return -1;
            }
            int time = (int) (taskData.getTime() - taskData2.getTime());
            if (time == 0) {
                return taskData.hashCode() - taskData2.hashCode();
            }
            return time;
        }
    }

    public void clear() {
        this.dataSet.clear();
    }

    public TaskDataSet copy() {
        TaskDataSet taskDataSet = new TaskDataSet();
        taskDataSet.dataSet.addAll(this.dataSet);
        return taskDataSet;
    }

    public TaskData getFirst() {
        if (this.dataSet.size() > 0) {
            return this.dataSet.iterator().next();
        }
        return null;
    }

    public TaskData getLast() {
        TaskData taskData = null;
        if (this.dataSet.size() > 0) {
            Iterator<TaskData> it = this.dataSet.iterator();
            while (it.hasNext()) {
                taskData = it.next();
            }
        }
        return taskData;
    }

    public TaskData getRandom() {
        TaskData taskData = null;
        if (this.dataSet.size() > 0) {
            int nextInt = new Random().nextInt(this.dataSet.size());
            Iterator<TaskData> it = this.dataSet.iterator();
            while (it.hasNext()) {
                taskData = it.next();
                int i = nextInt - 1;
                if (nextInt <= 0) {
                    break;
                }
                nextInt = i;
            }
        }
        return taskData;
    }

    public boolean isEmpty() {
        return this.dataSet.isEmpty();
    }

    public Iterator<TaskData> iterator() {
        return this.dataSet.iterator();
    }

    public TaskData removeFirst() {
        if (this.dataSet.size() > 0) {
            Iterator<TaskData> it = this.dataSet.iterator();
            TaskData next = it.next();
            it.remove();
            return next;
        }
        return null;
    }

    public TaskData removeLast() {
        TaskData last = getLast();
        if (last != null) {
            remove(last);
        }
        return last;
    }

    public int size() {
        return this.dataSet.size();
    }

    public boolean add(TaskData taskData) {
        return this.dataSet.add(taskData);
    }

    public void addAll(Collection<TaskData> collection) {
        this.dataSet.addAll(collection);
    }

    public boolean remove(TaskData taskData) {
        if (this.dataSet.size() <= 0) {
            return false;
        }
        Iterator<TaskData> it = this.dataSet.iterator();
        while (it.hasNext()) {
            if (it.next().equals(taskData)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    public boolean save(TaskData taskData) {
        this.dataSet.remove(taskData);
        return this.dataSet.add(taskData);
    }

    public boolean update(TaskData taskData) {
        remove(taskData);
        return this.dataSet.add(taskData);
    }
}
