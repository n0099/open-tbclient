package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.data.SystemMsgData;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class x87 {
    public static /* synthetic */ Interceptable $ic;
    public static Pattern a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755217638, "Lcom/repackage/x87;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755217638, "Lcom/repackage/x87;");
                return;
            }
        }
        a = Pattern.compile("(#\\([^#\\)\\(]+\\))");
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString(TbEnum.SystemMessage.KEY_EVENT_ID);
                String optString2 = jSONObject.optString(TbEnum.SystemMessage.KEY_USER_MSG);
                JSONObject optJSONObject = jSONObject.optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
                if (TextUtils.isEmpty(optString)) {
                    return null;
                }
                if (optString.equals(TbEnum.SystemMessage.EVENT_ID_FAKE)) {
                    return optString2;
                }
                if (optJSONObject == null) {
                    return null;
                }
                if (optString.equals(TbEnum.SystemMessage.EVENT_ID_KICKED_OUT)) {
                    return TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0983);
                }
                if (!optString.equals(TbEnum.SystemMessage.EVENT_ID_HIDE_GROUP) && !optString.equals(TbEnum.SystemMessage.EVENT_ID_HIDE_GROUP_WARN)) {
                    if (optString.equals(TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN)) {
                        String optString3 = optJSONObject.optString("userId");
                        String optString4 = optJSONObject.optString(TbEnum.SystemMessage.KEY_USER_NAME);
                        if (optString3.equals(TbadkCoreApplication.getCurrentAccount())) {
                            return TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f097f);
                        }
                        return optString4 + TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f097e);
                    } else if (optString.equals(TbEnum.SystemMessage.EVENT_ID_GROUP_QUIT)) {
                        return optJSONObject.optString("userId").equals(TbadkCoreApplication.getCurrentAccount()) ? TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0983) : optString2;
                    } else if (optString.equals(TbEnum.SystemMessage.EVENT_ID_APPLY_SUC)) {
                        return TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f097f);
                    } else {
                        if (!optString.equals(TbEnum.SystemMessage.EVENT_ID_INVITE_GROUP) && !optString.equals(TbEnum.SystemMessage.EVENT_ID_COMMON) && optString.equals(TbEnum.SystemMessage.EVENT_ID_GROUP_ACTIVITYS_IN_CHAT)) {
                        }
                    }
                }
                return optString2;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static final String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            StringBuilder sb = new StringBuilder();
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    if (optJSONObject != null && !optJSONObject.isNull("type")) {
                        int optInt = optJSONObject.optInt("type");
                        if (optInt == 0) {
                            sb.append(optJSONObject.opt("text"));
                        } else if (optInt == 2) {
                            sb.append(SmallTailInfo.EMOTION_PREFIX);
                            sb.append(optJSONObject.opt("c"));
                            sb.append(SmallTailInfo.EMOTION_SUFFIX);
                        }
                    }
                }
            } catch (Error e) {
                e.printStackTrace();
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String c(ChatMessage chatMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, chatMessage)) == null) {
            if (chatMessage == null) {
                return null;
            }
            UserData userInfo = chatMessage.getUserInfo();
            String userName = (userInfo == null || TextUtils.isEmpty(userInfo.getUserName())) ? "" : chatMessage.getUserInfo().getUserName();
            if (userInfo != null && !TextUtils.isEmpty(userInfo.getUserId()) && userInfo.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                return v(chatMessage);
            }
            if (chatMessage.getMsgType() == 11) {
                return v(chatMessage);
            }
            if (chatMessage.getToUserId() != 0) {
                return v(chatMessage);
            }
            if (!TextUtils.isEmpty(userName)) {
                return userName + ":" + v(chatMessage);
            }
            return v(chatMessage);
        }
        return (String) invokeL.objValue;
    }

    public static int d(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, context, i)) == null) ? context.getResources().getDimensionPixelSize(i) : invokeLI.intValue;
    }

    public static final String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            StringBuilder sb = new StringBuilder();
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() >= 2) {
                    String optString = jSONArray.optString(0);
                    if (1 == jSONArray.optInt(1)) {
                        sb.append(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f09c4));
                    }
                    if (optString != null) {
                        sb.append(optString);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String f(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65542, null, str, z)) == null) {
            if (str == null) {
                return null;
            }
            try {
                return new JSONArray(str).getJSONObject(0).optString(z ? "big_src" : "src");
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeLZ.objValue;
    }

    public static String g(JSONObject jSONObject, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65543, null, jSONObject, z)) == null) {
            return jSONObject.optString(z ? "big_src" : "src");
        }
        return (String) invokeLZ.objValue;
    }

    public static MsgCacheData h(ChatMessage chatMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, chatMessage)) == null) {
            try {
                MsgCacheData msgCacheData = new MsgCacheData();
                msgCacheData.setRich_content(null);
                return msgCacheData;
            } catch (Exception unused) {
                return null;
            }
        }
        return (MsgCacheData) invokeL.objValue;
    }

    public static z57 i(CommonMsgPojo commonMsgPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, commonMsgPojo)) == null) {
            if (commonMsgPojo != null && commonMsgPojo.getMsg_type() == 7) {
                return k(commonMsgPojo.getContent());
            }
            return null;
        }
        return (z57) invokeL.objValue;
    }

    public static z57 j(String str) {
        InterceptResult invokeL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            if (TextUtils.isEmpty(str) || (split = str.split("_")) == null || split.length != 2) {
                return null;
            }
            z57 z57Var = new z57();
            z57Var.a = split[0];
            z57Var.b = split[1];
            return z57Var;
        }
        return (z57) invokeL.objValue;
    }

    public static z57 k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() > 0) {
                    return j(jSONArray.getJSONObject(0).optString("msg_src"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
        return (z57) invokeL.objValue;
    }

    public static SystemMsgData l(ChatMessage chatMessage) {
        InterceptResult invokeL;
        String optString;
        String optString2;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, chatMessage)) == null) {
            if (chatMessage == null || chatMessage.getMsgType() != 11 || TextUtils.isEmpty(chatMessage.getContent())) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(chatMessage.getContent());
                optString = jSONObject.optString(TbEnum.SystemMessage.KEY_EVENT_ID);
                optString2 = jSONObject.optString(TbEnum.SystemMessage.KEY_USER_MSG);
                optJSONObject = jSONObject.optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (!TextUtils.isEmpty(optString) && optJSONObject != null) {
                if (optString.equals(TbEnum.SystemMessage.EVENT_ID_KICKED_OUT)) {
                    SystemMsgData systemMsgData = new SystemMsgData();
                    systemMsgData.setIsSelf(true);
                    systemMsgData.setContent(TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0983));
                    return systemMsgData;
                }
                if (!optString.equals(TbEnum.SystemMessage.EVENT_ID_HIDE_GROUP) && !optString.equals(TbEnum.SystemMessage.EVENT_ID_HIDE_GROUP_WARN)) {
                    if (optString.equals(TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN)) {
                        String optString3 = optJSONObject.optString("userId");
                        String optString4 = optJSONObject.optString(TbEnum.SystemMessage.KEY_USER_NAME);
                        SystemMsgData systemMsgData2 = new SystemMsgData();
                        if (optString3.equals(TbadkCoreApplication.getCurrentAccount())) {
                            systemMsgData2.setIsSelf(true);
                            systemMsgData2.setContent(TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f097f));
                        } else {
                            systemMsgData2.setIsSelf(false);
                            systemMsgData2.setContent(optString4 + TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f097e));
                        }
                        return systemMsgData2;
                    } else if (optString.equals(TbEnum.SystemMessage.EVENT_ID_GROUP_QUIT)) {
                        String optString5 = optJSONObject.optString("userId");
                        SystemMsgData systemMsgData3 = new SystemMsgData();
                        if (optString5.equals(TbadkCoreApplication.getCurrentAccount())) {
                            systemMsgData3.setIsSelf(true);
                            systemMsgData3.setContent(TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0983));
                        } else {
                            systemMsgData3.setIsSelf(false);
                            systemMsgData3.setContent(optString2);
                        }
                        return systemMsgData3;
                    } else {
                        if (optString.equals(TbEnum.SystemMessage.EVENT_ID_APPLY_SUC)) {
                            SystemMsgData systemMsgData4 = new SystemMsgData();
                            systemMsgData4.setIsSelf(true);
                            systemMsgData4.setContent(TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f097f));
                        } else if (optString.equals(TbEnum.SystemMessage.EVENT_ID_GROUP_ACTIVITYS_IN_CHAT)) {
                            SystemMsgData systemMsgData5 = new SystemMsgData();
                            systemMsgData5.setIsSelf(true);
                            systemMsgData5.setContent(optString2);
                            return systemMsgData5;
                        }
                        return null;
                    }
                }
                SystemMsgData systemMsgData6 = new SystemMsgData();
                systemMsgData6.setIsSelf(true);
                systemMsgData6.setContent(optString2);
                return systemMsgData6;
            }
            return null;
        }
        return (SystemMsgData) invokeL.objValue;
    }

    public static long m(ChatMessage chatMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, chatMessage)) == null) {
            if (chatMessage == null) {
                return -1L;
            }
            if (mg.g(TbadkCoreApplication.getCurrentAccount(), -1L) == chatMessage.getUserId()) {
                return chatMessage.getToUserId();
            }
            return chatMessage.getUserId();
        }
        return invokeL.longValue;
    }

    public static VoiceMsgData n(ChatMessage chatMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, chatMessage)) == null) {
            VoiceMsgData voiceMsgData = null;
            if (chatMessage == null || chatMessage.getMsgType() != 3) {
                return null;
            }
            if (chatMessage.getObjContent() != null) {
                return (VoiceMsgData) chatMessage.getObjContent();
            }
            String content = chatMessage.getContent();
            if (TextUtils.isEmpty(content)) {
                VoiceMsgData voiceMsgData2 = new VoiceMsgData();
                chatMessage.setObjContent(voiceMsgData2);
                return voiceMsgData2;
            }
            try {
                JSONArray jSONArray = new JSONArray(content);
                if (jSONArray.length() > 0) {
                    if (jSONArray.length() > 0) {
                        try {
                            voiceMsgData = (VoiceMsgData) OrmObject.objectWithJson(jSONArray.getJSONObject(0), VoiceMsgData.class);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    chatMessage.setObjContent(voiceMsgData);
                    return voiceMsgData;
                }
                return null;
            } catch (Exception unused) {
                return voiceMsgData;
            }
        }
        return (VoiceMsgData) invokeL.objValue;
    }

    public static boolean o(ChatMessage chatMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, chatMessage)) == null) {
            if (chatMessage == null) {
                return true;
            }
            String content = chatMessage.getContent();
            if (StringUtils.isJSONArray(content)) {
                try {
                    JSONArray jSONArray = new JSONArray(content);
                    if (jSONArray.length() > 0) {
                        return ((JSONObject) jSONArray.get(0)).optInt("switch", -1) == 0;
                    }
                    return true;
                } catch (JSONException e) {
                    e.printStackTrace();
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean p(ChatMessage chatMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, chatMessage)) == null) {
            try {
                if (chatMessage.getMsgType() != 11 && TbadkCoreApplication.isLogin()) {
                    if (chatMessage.getUserInfo().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                        return true;
                    }
                }
            } catch (Exception unused) {
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean q(ChatMessage chatMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65553, null, chatMessage)) == null) ? chatMessage != null && chatMessage.getMsgType() == 4 : invokeL.booleanValue;
    }

    public static boolean r(ChatMessage chatMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65554, null, chatMessage)) == null) ? chatMessage != null && chatMessage.getMsgType() == 6 : invokeL.booleanValue;
    }

    public static boolean s(ChatMessage chatMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65555, null, chatMessage)) == null) ? chatMessage != null && chatMessage.getMsgType() == 2 : invokeL.booleanValue;
    }

    public static boolean t(ChatMessage chatMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65556, null, chatMessage)) == null) ? chatMessage != null && chatMessage.getMsgType() == 3 : invokeL.booleanValue;
    }

    public static String u(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeIL = interceptable.invokeIL(65557, null, i, str)) != null) {
            return (String) invokeIL.objValue;
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (i == 1) {
            String b = (str.length() <= 1 || str.charAt(0) != '[') ? null : b(str);
            if (!TextUtils.isEmpty(b)) {
                str = b;
            }
            if (str == null) {
                return null;
            }
            Matcher matcher = a.matcher(str);
            while (matcher.find()) {
                String group = matcher.group();
                str = str.replace(group, group.replace(SmallTailInfo.EMOTION_PREFIX, PreferencesUtil.LEFT_MOUNT).replace(SmallTailInfo.EMOTION_SUFFIX, PreferencesUtil.RIGHT_MOUNT));
            }
            return str;
        } else if (i == 2) {
            return TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f09c6);
        } else {
            if (i == 3) {
                return TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f09c9);
            }
            if (i == 11) {
                return a(str);
            }
            if (i == 23) {
                return TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f09c8);
            }
            if (i != 4) {
                if (i == 5) {
                    return TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f09c5);
                }
                if (i == 6) {
                    try {
                        return new JSONObject(str).optString(TbEnum.SystemMessage.KEY_USER_MSG);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        return "";
                    }
                } else if (i == 7) {
                    String string = TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f09c7);
                    if (TextUtils.isEmpty(str)) {
                        return string;
                    }
                    try {
                        JSONArray jSONArray = new JSONArray(str);
                        if (jSONArray.length() > 0) {
                            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                                String string2 = ((JSONObject) jSONArray.get(i2)).getString("title");
                                if (!TextUtils.isEmpty(string2)) {
                                    return string2;
                                }
                            }
                        }
                        return string;
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                        return string;
                    }
                } else if (i != 25) {
                    if (i == 9) {
                        return e(str);
                    }
                    return null;
                } else if (TextUtils.isEmpty(str)) {
                    return TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f07d2);
                } else {
                    try {
                        JSONArray jSONArray2 = new JSONArray(str);
                        if (jSONArray2.length() > 0) {
                            JSONObject optJSONObject = jSONArray2.optJSONObject(0);
                            String optString = optJSONObject.optString("nick_name");
                            String optString2 = optJSONObject.optString("caller_content");
                            int optInt = optJSONObject.optInt("remind_count");
                            int optInt2 = optJSONObject.optInt("msg_type");
                            if (optInt2 == 1) {
                                return String.format(TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f07d3), optString, optString2);
                            }
                            return optInt2 == 3 ? String.format(TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f149f), Integer.valueOf(optInt)) : optString2;
                        }
                        return "";
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                        return TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f07d2);
                    }
                }
            }
            try {
                JSONArray jSONArray3 = new JSONArray(str);
                if (jSONArray3.length() > 0) {
                    String optString3 = jSONArray3.getJSONObject(0).optString("face_name");
                    if (optString3 != null && optString3.startsWith(SmallTailInfo.EMOTION_PREFIX) && optString3.endsWith(SmallTailInfo.EMOTION_SUFFIX)) {
                        return PreferencesUtil.LEFT_MOUNT + optString3.substring(2, optString3.length() - 1) + PreferencesUtil.RIGHT_MOUNT;
                    }
                    return optString3;
                }
                return null;
            } catch (JSONException e4) {
                e4.printStackTrace();
                try {
                    String optString4 = new JSONObject(str).optString("face_name");
                    if (optString4 != null && optString4.startsWith(SmallTailInfo.EMOTION_PREFIX) && optString4.endsWith(SmallTailInfo.EMOTION_SUFFIX)) {
                        return PreferencesUtil.LEFT_MOUNT + optString4.substring(2, optString4.length() - 1) + PreferencesUtil.RIGHT_MOUNT;
                    }
                    return optString4;
                } catch (JSONException e5) {
                    e5.printStackTrace();
                }
            }
        }
    }

    public static String v(ChatMessage chatMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65558, null, chatMessage)) == null) ? chatMessage == null ? "" : u(chatMessage.getMsgType(), chatMessage.getContent()) : (String) invokeL.objValue;
    }
}
