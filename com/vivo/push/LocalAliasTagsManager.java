package com.vivo.push;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.cache.ISubscribeAppAliasManager;
import com.vivo.push.cache.ISubscribeAppTagManager;
import com.vivo.push.cache.impl.SubscribeAppAliasManagerImpl;
import com.vivo.push.model.SubscribeAppInfo;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.model.UnvarnishedMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
/* loaded from: classes6.dex */
public class LocalAliasTagsManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_LOCAL_REQUEST_ID = "push_cache_sp";
    public static final Object SLOCK;
    public static final String TAG = "LocalAliasTagsManager";
    public static final ExecutorService WORK_POOL;
    public static volatile LocalAliasTagsManager mLocalAliasTagsManager;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public Handler mHandler;
    public ISubscribeAppAliasManager mSubscribeAppAliasManager;
    public ISubscribeAppTagManager mSubscribeAppTagManager;

    /* loaded from: classes6.dex */
    public interface LocalMessageCallback {
        boolean onNotificationMessageArrived(Context context, UPSNotificationMessage uPSNotificationMessage);

        void onTransmissionMessage(Context context, UnvarnishedMessage unvarnishedMessage);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2002473832, "Lcom/vivo/push/LocalAliasTagsManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2002473832, "Lcom/vivo/push/LocalAliasTagsManager;");
                return;
            }
        }
        WORK_POOL = com.vivo.push.util.e.a(TAG);
        SLOCK = new Object();
    }

    public LocalAliasTagsManager(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContext = context;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mSubscribeAppTagManager = new com.vivo.push.cache.impl.b(context);
        this.mSubscribeAppAliasManager = new SubscribeAppAliasManagerImpl(context);
    }

    public static final LocalAliasTagsManager getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) {
            if (mLocalAliasTagsManager == null) {
                synchronized (SLOCK) {
                    if (mLocalAliasTagsManager == null) {
                        mLocalAliasTagsManager = new LocalAliasTagsManager(context.getApplicationContext());
                    }
                }
            }
            return mLocalAliasTagsManager;
        }
        return (LocalAliasTagsManager) invokeL.objValue;
    }

    public void delLocalAlias(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            WORK_POOL.execute(new h(this, str));
        }
    }

    public void delLocalTags(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList) == null) {
            WORK_POOL.execute(new i(this, arrayList));
        }
    }

    public String getLocalAlias() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            SubscribeAppInfo subscribeAppInfo = this.mSubscribeAppAliasManager.getSubscribeAppInfo();
            if (subscribeAppInfo != null) {
                return subscribeAppInfo.getName();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public List<String> getLocalTags() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mSubscribeAppTagManager.getSubscribeTags() : (List) invokeV.objValue;
    }

    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            WORK_POOL.execute(new g(this));
        }
    }

    public void onDelAlias(List<String> list, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, list, str) == null) && DEFAULT_LOCAL_REQUEST_ID.equals(str)) {
            WORK_POOL.execute(new l(this, list));
        }
    }

    public void onDelTags(List<String> list, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, list, str) == null) && DEFAULT_LOCAL_REQUEST_ID.equals(str)) {
            WORK_POOL.execute(new m(this, list));
        }
    }

    public void onReceiverMsg(UnvarnishedMessage unvarnishedMessage, LocalMessageCallback localMessageCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, unvarnishedMessage, localMessageCallback) == null) {
            WORK_POOL.execute(new j(this, unvarnishedMessage, localMessageCallback));
        }
    }

    public boolean onReceiverNotification(UPSNotificationMessage uPSNotificationMessage, LocalMessageCallback localMessageCallback) {
        InterceptResult invokeLL;
        List<String> subscribeTags;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, uPSNotificationMessage, localMessageCallback)) == null) {
            int targetType = uPSNotificationMessage.getTargetType();
            String tragetContent = uPSNotificationMessage.getTragetContent();
            if (targetType != 3) {
                if (targetType == 4 && ((subscribeTags = this.mSubscribeAppTagManager.getSubscribeTags()) == null || !subscribeTags.contains(tragetContent))) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    arrayList.add(tragetContent);
                    p.a().b(DEFAULT_LOCAL_REQUEST_ID, arrayList);
                    com.vivo.push.util.p.a(TAG, tragetContent + " has ignored ; current tags is " + subscribeTags);
                    return true;
                }
            } else {
                SubscribeAppInfo subscribeAppInfo = this.mSubscribeAppAliasManager.getSubscribeAppInfo();
                if (subscribeAppInfo == null || subscribeAppInfo.getTargetStatus() != 1 || !subscribeAppInfo.getName().equals(tragetContent)) {
                    p.a().b(DEFAULT_LOCAL_REQUEST_ID, tragetContent);
                    com.vivo.push.util.p.a(TAG, tragetContent + " has ignored ; current Alias is " + subscribeAppInfo);
                    return true;
                }
            }
            return localMessageCallback.onNotificationMessageArrived(this.mContext, uPSNotificationMessage);
        }
        return invokeLL.booleanValue;
    }

    public void onSetAlias(List<String> list, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, list, str) == null) && DEFAULT_LOCAL_REQUEST_ID.equals(str)) {
            WORK_POOL.execute(new n(this, list));
        }
    }

    public void onSetTags(List<String> list, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048586, this, list, str) == null) && DEFAULT_LOCAL_REQUEST_ID.equals(str)) {
            WORK_POOL.execute(new e(this, list));
        }
    }

    public void setLocalAlias(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            WORK_POOL.execute(new d(this, str));
        }
    }

    public void setLocalTags(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, arrayList) == null) {
            WORK_POOL.execute(new f(this, arrayList));
        }
    }

    public void setSubscribeAppAliasManager(ISubscribeAppAliasManager iSubscribeAppAliasManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, iSubscribeAppAliasManager) == null) {
            this.mSubscribeAppAliasManager = iSubscribeAppAliasManager;
        }
    }

    public void setSubscribeAppTagManager(ISubscribeAppTagManager iSubscribeAppTagManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, iSubscribeAppTagManager) == null) {
            this.mSubscribeAppTagManager = iSubscribeAppTagManager;
        }
    }
}
