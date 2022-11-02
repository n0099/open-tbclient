package com.xiaomi.mipush.sdk;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.mipush.sdk.PushMessageHandler;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class MiPushMessage implements PushMessageHandler.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_ALIAS = "alias";
    public static final String KEY_CATEGORY = "category";
    public static final String KEY_CONTENT = "content";
    public static final String KEY_DESC = "description";
    public static final String KEY_EXTRA = "extra";
    public static final String KEY_MESSAGE_ID = "messageId";
    public static final String KEY_MESSAGE_TYPE = "messageType";
    public static final String KEY_NOTIFIED = "isNotified";
    public static final String KEY_NOTIFY_ID = "notifyId";
    public static final String KEY_NOTIFY_TYPE = "notifyType";
    public static final String KEY_PASS_THROUGH = "passThrough";
    public static final String KEY_TITLE = "title";
    public static final String KEY_TOPIC = "topic";
    public static final String KEY_USER_ACCOUNT = "user_account";
    public static final int MESSAGE_TYPE_ACCOUNT = 3;
    public static final int MESSAGE_TYPE_ALIAS = 1;
    public static final int MESSAGE_TYPE_REG = 0;
    public static final int MESSAGE_TYPE_TOPIC = 2;
    public static final long serialVersionUID = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public String alias;
    public boolean arrived;
    public String category;
    public String content;
    public String description;
    public HashMap<String, String> extra;
    public boolean isNotified;
    public String messageId;
    public int messageType;
    public int notifyId;
    public int notifyType;
    public int passThrough;
    public String title;
    public String topic;
    public String userAccount;

    public MiPushMessage() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.arrived = false;
        this.extra = new HashMap<>();
    }

    public static MiPushMessage fromBundle(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bundle)) == null) {
            MiPushMessage miPushMessage = new MiPushMessage();
            miPushMessage.messageId = bundle.getString(KEY_MESSAGE_ID);
            miPushMessage.messageType = bundle.getInt("messageType");
            miPushMessage.passThrough = bundle.getInt(KEY_PASS_THROUGH);
            miPushMessage.alias = bundle.getString("alias");
            miPushMessage.userAccount = bundle.getString(KEY_USER_ACCOUNT);
            miPushMessage.topic = bundle.getString("topic");
            miPushMessage.content = bundle.getString("content");
            miPushMessage.description = bundle.getString("description");
            miPushMessage.title = bundle.getString("title");
            miPushMessage.isNotified = bundle.getBoolean(KEY_NOTIFIED);
            miPushMessage.notifyId = bundle.getInt(KEY_NOTIFY_ID);
            miPushMessage.notifyType = bundle.getInt(KEY_NOTIFY_TYPE);
            miPushMessage.category = bundle.getString("category");
            miPushMessage.extra = (HashMap) bundle.getSerializable("extra");
            return miPushMessage;
        }
        return (MiPushMessage) invokeL.objValue;
    }

    public String getAlias() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.alias : (String) invokeV.objValue;
    }

    public String getCategory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.category : (String) invokeV.objValue;
    }

    public String getContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.content : (String) invokeV.objValue;
    }

    public String getDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.description : (String) invokeV.objValue;
    }

    public Map<String, String> getExtra() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.extra : (Map) invokeV.objValue;
    }

    public String getMessageId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.messageId : (String) invokeV.objValue;
    }

    public int getMessageType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.messageType : invokeV.intValue;
    }

    public int getNotifyId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.notifyId : invokeV.intValue;
    }

    public int getNotifyType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.notifyType : invokeV.intValue;
    }

    public int getPassThrough() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.passThrough : invokeV.intValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.title : (String) invokeV.objValue;
    }

    public String getTopic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.topic : (String) invokeV.objValue;
    }

    public String getUserAccount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.userAccount : (String) invokeV.objValue;
    }

    public boolean isArrivedMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.arrived : invokeV.booleanValue;
    }

    public boolean isNotified() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.isNotified : invokeV.booleanValue;
    }

    public void setAlias(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.alias = str;
        }
    }

    public void setArrivedMessage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.arrived = z;
        }
    }

    public void setCategory(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.category = str;
        }
    }

    public void setContent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.content = str;
        }
    }

    public void setDescription(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.description = str;
        }
    }

    public void setExtra(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, map) == null) {
            this.extra.clear();
            if (map != null) {
                this.extra.putAll(map);
            }
        }
    }

    public void setMessageId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.messageId = str;
        }
    }

    public void setMessageType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            this.messageType = i;
        }
    }

    public void setNotified(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.isNotified = z;
        }
    }

    public void setNotifyId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            this.notifyId = i;
        }
    }

    public void setNotifyType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            this.notifyType = i;
        }
    }

    public void setPassThrough(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            this.passThrough = i;
        }
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            this.title = str;
        }
    }

    public void setTopic(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, str) == null) {
            this.topic = str;
        }
    }

    public void setUserAccount(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            this.userAccount = str;
        }
    }

    public Bundle toBundle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            Bundle bundle = new Bundle();
            bundle.putString(KEY_MESSAGE_ID, this.messageId);
            bundle.putInt(KEY_PASS_THROUGH, this.passThrough);
            bundle.putInt("messageType", this.messageType);
            if (!TextUtils.isEmpty(this.alias)) {
                bundle.putString("alias", this.alias);
            }
            if (!TextUtils.isEmpty(this.userAccount)) {
                bundle.putString(KEY_USER_ACCOUNT, this.userAccount);
            }
            if (!TextUtils.isEmpty(this.topic)) {
                bundle.putString("topic", this.topic);
            }
            bundle.putString("content", this.content);
            if (!TextUtils.isEmpty(this.description)) {
                bundle.putString("description", this.description);
            }
            if (!TextUtils.isEmpty(this.title)) {
                bundle.putString("title", this.title);
            }
            bundle.putBoolean(KEY_NOTIFIED, this.isNotified);
            bundle.putInt(KEY_NOTIFY_ID, this.notifyId);
            bundle.putInt(KEY_NOTIFY_TYPE, this.notifyType);
            if (!TextUtils.isEmpty(this.category)) {
                bundle.putString("category", this.category);
            }
            HashMap<String, String> hashMap = this.extra;
            if (hashMap != null) {
                bundle.putSerializable("extra", hashMap);
            }
            return bundle;
        }
        return (Bundle) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return "messageId={" + this.messageId + "},passThrough={" + this.passThrough + "},alias={" + this.alias + "},topic={" + this.topic + "},userAccount={" + this.userAccount + "},content={" + this.content + "},description={" + this.description + "},title={" + this.title + "},isNotified={" + this.isNotified + "},notifyId={" + this.notifyId + "},notifyType={" + this.notifyType + "}, category={" + this.category + "}, extra={" + this.extra + "}";
        }
        return (String) invokeV.objValue;
    }
}
