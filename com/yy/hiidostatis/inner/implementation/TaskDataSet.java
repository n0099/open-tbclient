package com.yy.hiidostatis.inner.implementation;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
/* loaded from: classes7.dex */
public class TaskDataSet implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Comparator<TaskData> DATA_COMPARATOR;
    public static final long serialVersionUID = -8880276834197410994L;
    public transient /* synthetic */ FieldHolder $fh;
    public Set<TaskData> dataSet;

    /* renamed from: com.yy.hiidostatis.inner.implementation.TaskDataSet$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static final class MyComparator implements Comparator<TaskData>, Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 605434724079570979L;
        public transient /* synthetic */ FieldHolder $fh;

        public MyComparator() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ MyComparator(AnonymousClass1 anonymousClass1) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        public int compare(TaskData taskData, TaskData taskData2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, taskData, taskData2)) == null) {
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
                return time == 0 ? taskData.hashCode() - taskData2.hashCode() : time;
            }
            return invokeLL.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2063495463, "Lcom/yy/hiidostatis/inner/implementation/TaskDataSet;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2063495463, "Lcom/yy/hiidostatis/inner/implementation/TaskDataSet;");
                return;
            }
        }
        DATA_COMPARATOR = new MyComparator(null);
    }

    public TaskDataSet() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.dataSet = new TreeSet(DATA_COMPARATOR);
    }

    public boolean add(TaskData taskData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, taskData)) == null) ? this.dataSet.add(taskData) : invokeL.booleanValue;
    }

    public void addAll(Collection<TaskData> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, collection) == null) {
            this.dataSet.addAll(collection);
        }
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.dataSet.clear();
        }
    }

    public TaskDataSet copy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            TaskDataSet taskDataSet = new TaskDataSet();
            taskDataSet.dataSet.addAll(this.dataSet);
            return taskDataSet;
        }
        return (TaskDataSet) invokeV.objValue;
    }

    public TaskData getFirst() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.dataSet.size() > 0) {
                return this.dataSet.iterator().next();
            }
            return null;
        }
        return (TaskData) invokeV.objValue;
    }

    public TaskData getLast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            TaskData taskData = null;
            if (this.dataSet.size() > 0) {
                Iterator<TaskData> it = this.dataSet.iterator();
                while (it.hasNext()) {
                    taskData = it.next();
                }
            }
            return taskData;
        }
        return (TaskData) invokeV.objValue;
    }

    public TaskData getRandom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
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
        return (TaskData) invokeV.objValue;
    }

    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.dataSet.isEmpty() : invokeV.booleanValue;
    }

    public Iterator<TaskData> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.dataSet.iterator() : (Iterator) invokeV.objValue;
    }

    public boolean remove(TaskData taskData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, taskData)) == null) {
            if (this.dataSet.size() > 0) {
                Iterator<TaskData> it = this.dataSet.iterator();
                while (it.hasNext()) {
                    if (it.next().equals(taskData)) {
                        it.remove();
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public TaskData removeFirst() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.dataSet.size() > 0) {
                Iterator<TaskData> it = this.dataSet.iterator();
                TaskData next = it.next();
                it.remove();
                return next;
            }
            return null;
        }
        return (TaskData) invokeV.objValue;
    }

    public TaskData removeLast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            TaskData last = getLast();
            if (last != null) {
                remove(last);
            }
            return last;
        }
        return (TaskData) invokeV.objValue;
    }

    public boolean save(TaskData taskData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, taskData)) == null) {
            this.dataSet.remove(taskData);
            return this.dataSet.add(taskData);
        }
        return invokeL.booleanValue;
    }

    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.dataSet.size() : invokeV.intValue;
    }

    public boolean update(TaskData taskData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, taskData)) == null) {
            remove(taskData);
            return this.dataSet.add(taskData);
        }
        return invokeL.booleanValue;
    }
}
