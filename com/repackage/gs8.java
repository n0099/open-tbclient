package com.repackage;

import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes6.dex */
public class gs8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(b9 b9Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, b9Var, str)) == null) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < jSONArray.length(); i++) {
                    sb.append(jSONArray.optJSONObject(i).optString("src"));
                }
                return sb.toString();
            } catch (JSONException e) {
                e.printStackTrace();
                return b9Var.getString(R.string.obfuscated_res_0x7f0f0e40);
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String b(b9 b9Var, ChatMessage chatMessage) {
        InterceptResult invokeLL;
        String content;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, b9Var, chatMessage)) == null) {
            int msgType = chatMessage.getMsgType();
            if (msgType == 1) {
                content = chatMessage.getContent();
            } else if (msgType != 2) {
                content = msgType != 3 ? "" : b9Var.getString(R.string.obfuscated_res_0x7f0f1532);
            } else {
                content = a(b9Var, chatMessage.getContent());
            }
            if (chatMessage != null && chatMessage.getToUserInfo() != null) {
                if (TextUtils.equals(chatMessage.getToUserInfo().getUserId(), String.valueOf(TbadkCoreApplication.getCurrentAccountId()))) {
                    string = b9Var.getString(R.string.obfuscated_res_0x7f0f0ed2);
                } else {
                    string = b9Var.getString(R.string.obfuscated_res_0x7f0f0ecf);
                }
                return string + chatMessage.getToUserInfo().getUserName() + b9Var.getString(R.string.obfuscated_res_0x7f0f0ed0) + content;
            }
            return b9Var.getString(R.string.obfuscated_res_0x7f0f0ecf);
        }
        return (String) invokeLL.objValue;
    }
}
