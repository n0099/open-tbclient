package io.reactivex.internal.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.io.Serializable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public final class NotificationLite {
    public static final /* synthetic */ NotificationLite[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final NotificationLite COMPLETE;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static final class DisposableNotification implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -7482590109178395495L;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public final Disposable f78582d;

        public DisposableNotification(Disposable disposable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {disposable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f78582d = disposable;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "NotificationLite.Disposable[" + this.f78582d + PreferencesUtil.RIGHT_MOUNT;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static final class ErrorNotification implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -8759979445933046293L;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final Throwable f78583e;

        public ErrorNotification(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {th};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f78583e = th;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (obj instanceof ErrorNotification) {
                    return ObjectHelper.equals(this.f78583e, ((ErrorNotification) obj).f78583e);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f78583e.hashCode() : invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return "NotificationLite.Error[" + this.f78583e + PreferencesUtil.RIGHT_MOUNT;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static final class SubscriptionNotification implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -1322257508628817540L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Subscription s;

        public SubscriptionNotification(Subscription subscription) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscription};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.s = subscription;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "NotificationLite.Subscription[" + this.s + PreferencesUtil.RIGHT_MOUNT;
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(165418234, "Lio/reactivex/internal/util/NotificationLite;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(165418234, "Lio/reactivex/internal/util/NotificationLite;");
                return;
            }
        }
        NotificationLite notificationLite = new NotificationLite("COMPLETE", 0);
        COMPLETE = notificationLite;
        $VALUES = new NotificationLite[]{notificationLite};
    }

    public NotificationLite(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static <T> boolean accept(Object obj, Subscriber<? super T> subscriber) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, obj, subscriber)) == null) {
            if (obj == COMPLETE) {
                subscriber.onComplete();
                return true;
            } else if (obj instanceof ErrorNotification) {
                subscriber.onError(((ErrorNotification) obj).f78583e);
                return true;
            } else {
                subscriber.onNext(obj);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static <T> boolean acceptFull(Object obj, Subscriber<? super T> subscriber) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, obj, subscriber)) == null) {
            if (obj == COMPLETE) {
                subscriber.onComplete();
                return true;
            } else if (obj instanceof ErrorNotification) {
                subscriber.onError(((ErrorNotification) obj).f78583e);
                return true;
            } else if (obj instanceof SubscriptionNotification) {
                subscriber.onSubscribe(((SubscriptionNotification) obj).s);
                return false;
            } else {
                subscriber.onNext(obj);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static Object complete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? COMPLETE : invokeV.objValue;
    }

    public static Object disposable(Disposable disposable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, disposable)) == null) ? new DisposableNotification(disposable) : invokeL.objValue;
    }

    public static Object error(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, th)) == null) ? new ErrorNotification(th) : invokeL.objValue;
    }

    public static Disposable getDisposable(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, obj)) == null) ? ((DisposableNotification) obj).f78582d : (Disposable) invokeL.objValue;
    }

    public static Throwable getError(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, obj)) == null) ? ((ErrorNotification) obj).f78583e : (Throwable) invokeL.objValue;
    }

    public static Subscription getSubscription(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, obj)) == null) ? ((SubscriptionNotification) obj).s : (Subscription) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T getValue(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, obj)) == null) ? obj : (T) invokeL.objValue;
    }

    public static boolean isComplete(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, obj)) == null) ? obj == COMPLETE : invokeL.booleanValue;
    }

    public static boolean isDisposable(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, obj)) == null) ? obj instanceof DisposableNotification : invokeL.booleanValue;
    }

    public static boolean isError(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65551, null, obj)) == null) ? obj instanceof ErrorNotification : invokeL.booleanValue;
    }

    public static boolean isSubscription(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, obj)) == null) ? obj instanceof SubscriptionNotification : invokeL.booleanValue;
    }

    public static <T> Object next(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65553, null, t)) == null) ? t : invokeL.objValue;
    }

    public static Object subscription(Subscription subscription) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65554, null, subscription)) == null) ? new SubscriptionNotification(subscription) : invokeL.objValue;
    }

    public static NotificationLite valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65555, null, str)) == null) ? (NotificationLite) Enum.valueOf(NotificationLite.class, str) : (NotificationLite) invokeL.objValue;
    }

    public static NotificationLite[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) ? (NotificationLite[]) $VALUES.clone() : (NotificationLite[]) invokeV.objValue;
    }

    @Override // java.lang.Enum
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "NotificationLite.Complete" : (String) invokeV.objValue;
    }

    public static <T> boolean accept(Object obj, Observer<? super T> observer) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, obj, observer)) == null) {
            if (obj == COMPLETE) {
                observer.onComplete();
                return true;
            } else if (obj instanceof ErrorNotification) {
                observer.onError(((ErrorNotification) obj).f78583e);
                return true;
            } else {
                observer.onNext(obj);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static <T> boolean acceptFull(Object obj, Observer<? super T> observer) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, obj, observer)) == null) {
            if (obj == COMPLETE) {
                observer.onComplete();
                return true;
            } else if (obj instanceof ErrorNotification) {
                observer.onError(((ErrorNotification) obj).f78583e);
                return true;
            } else if (obj instanceof DisposableNotification) {
                observer.onSubscribe(((DisposableNotification) obj).f78582d);
                return false;
            } else {
                observer.onNext(obj);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }
}
