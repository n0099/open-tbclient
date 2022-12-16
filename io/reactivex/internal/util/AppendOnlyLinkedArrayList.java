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
/* loaded from: classes9.dex */
public class AppendOnlyLinkedArrayList<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int capacity;
    public final Object[] head;
    public int offset;
    public Object[] tail;

    /* loaded from: classes9.dex */
    public interface NonThrowingPredicate<T> extends Predicate<T> {
        @Override // io.reactivex.functions.Predicate
        boolean test(T t);
    }

    public AppendOnlyLinkedArrayList(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.capacity = i;
        Object[] objArr2 = new Object[i + 1];
        this.head = objArr2;
        this.tail = objArr2;
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, observer)) == null) {
            Object[] objArr = this.head;
            int i = this.capacity;
            while (true) {
                if (objArr == null) {
                    return false;
                }
                for (int i2 = 0; i2 < i; i2++) {
                    Object[] objArr2 = objArr[i2];
                    if (objArr2 == null) {
                        break;
                    } else if (NotificationLite.acceptFull(objArr2, observer)) {
                        return true;
                    }
                }
                objArr = objArr[i];
            }
        } else {
            return invokeL.booleanValue;
        }
    }

    public void add(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) {
            int i = this.capacity;
            int i2 = this.offset;
            if (i2 == i) {
                Object[] objArr = new Object[i + 1];
                this.tail[i] = objArr;
                this.tail = objArr;
                i2 = 0;
            }
            this.tail[i2] = t;
            this.offset = i2 + 1;
        }
    }

    public void forEachWhile(NonThrowingPredicate<? super T> nonThrowingPredicate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, nonThrowingPredicate) == null) {
            int i = this.capacity;
            for (Object[] objArr = this.head; objArr != null; objArr = objArr[i]) {
                for (int i2 = 0; i2 < i; i2++) {
                    Object obj = objArr[i2];
                    if (obj != null && !nonThrowingPredicate.test(obj)) {
                    }
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
    public <U> boolean accept(Subscriber<? super U> subscriber) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, subscriber)) == null) {
            Object[] objArr = this.head;
            int i = this.capacity;
            while (true) {
                if (objArr == null) {
                    return false;
                }
                for (int i2 = 0; i2 < i; i2++) {
                    Object[] objArr2 = objArr[i2];
                    if (objArr2 == null) {
                        break;
                    } else if (NotificationLite.acceptFull(objArr2, subscriber)) {
                        return true;
                    }
                }
                objArr = objArr[i];
            }
        } else {
            return invokeL.booleanValue;
        }
    }

    public <S> void forEachWhile(S s, BiPredicate<? super S, ? super T> biPredicate) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, s, biPredicate) == null) {
            Object[] objArr = this.head;
            int i = this.capacity;
            while (true) {
                for (int i2 = 0; i2 < i; i2++) {
                    Object obj = objArr[i2];
                    if (obj == null || biPredicate.test(s, obj)) {
                        return;
                    }
                }
                objArr = objArr[i];
            }
        }
    }
}
