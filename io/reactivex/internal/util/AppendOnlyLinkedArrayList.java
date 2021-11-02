package io.reactivex.internal.util;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Observer;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.Predicate;
import org.reactivestreams.Subscriber;
/* loaded from: classes3.dex */
public class AppendOnlyLinkedArrayList<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int capacity;
    public final Object[] head;
    public int offset;
    public Object[] tail;

    /* loaded from: classes3.dex */
    public interface NonThrowingPredicate<T> extends Predicate<T> {
        @Override // io.reactivex.functions.Predicate
        boolean test(T t);
    }

    public AppendOnlyLinkedArrayList(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.capacity = i2;
        Object[] objArr2 = new Object[i2 + 1];
        this.head = objArr2;
        this.tail = objArr2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x001d, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <U> boolean accept(Subscriber<? super U> subscriber) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, subscriber)) != null) {
            return invokeL.booleanValue;
        }
        Object[] objArr = this.head;
        int i2 = this.capacity;
        while (true) {
            if (objArr == null) {
                return false;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                Object[] objArr2 = objArr[i3];
                if (objArr2 == null) {
                    break;
                } else if (NotificationLite.acceptFull(objArr2, subscriber)) {
                    return true;
                }
            }
            objArr = objArr[i2];
        }
    }

    public void add(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) {
            int i2 = this.capacity;
            int i3 = this.offset;
            if (i3 == i2) {
                Object[] objArr = new Object[i2 + 1];
                this.tail[i2] = objArr;
                this.tail = objArr;
                i3 = 0;
            }
            this.tail[i3] = t;
            this.offset = i3 + 1;
        }
    }

    public void forEachWhile(NonThrowingPredicate<? super T> nonThrowingPredicate) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, nonThrowingPredicate) == null) {
            int i3 = this.capacity;
            for (Object[] objArr = this.head; objArr != null; objArr = objArr[i3]) {
                while (i2 < i3) {
                    Object obj = objArr[i2];
                    i2 = (obj == null || nonThrowingPredicate.test(obj)) ? 0 : i2 + 1;
                }
            }
        }
    }

    public void setFirst(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, t) == null) {
            this.head[0] = t;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x001d, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <U> boolean accept(Observer<? super U> observer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, observer)) != null) {
            return invokeL.booleanValue;
        }
        Object[] objArr = this.head;
        int i2 = this.capacity;
        while (true) {
            if (objArr == null) {
                return false;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                Object[] objArr2 = objArr[i3];
                if (objArr2 == null) {
                    break;
                } else if (NotificationLite.acceptFull(objArr2, observer)) {
                    return true;
                }
            }
            objArr = objArr[i2];
        }
    }

    public <S> void forEachWhile(S s, BiPredicate<? super S, ? super T> biPredicate) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(1048580, this, s, biPredicate) != null) {
            return;
        }
        Object[] objArr = this.head;
        int i2 = this.capacity;
        while (true) {
            for (int i3 = 0; i3 < i2; i3++) {
                Object obj = objArr[i3];
                if (obj == null || biPredicate.test(s, obj)) {
                    return;
                }
            }
            objArr = objArr[i2];
        }
    }
}
