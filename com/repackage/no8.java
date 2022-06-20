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
public class no8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(d9 d9Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, d9Var, str)) == null) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < jSONArray.length(); i++) {
                    sb.append(jSONArray.optJSONObject(i).optString("src"));
                }
                return sb.toString();
            } catch (JSONException e) {
                e.printStackTrace();
                return d9Var.getString(R.string.obfuscated_res_0x7f0f0e6a);
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String b(d9 d9Var, ChatMessage chatMessage) {
        InterceptResult invokeLL;
        String content;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, d9Var, chatMessage)) == null) {
            int msgType = chatMessage.getMsgType();
            if (msgType != 1) {
                if (msgType == 2) {
                    content = a(d9Var, chatMessage.getContent());
                } else if (msgType == 3) {
                    content = d9Var.getString(R.string.obfuscated_res_0x7f0f157f);
                } else if (msgType != 30) {
                    if (msgType != 32) {
                        content = msgType != 33 ? "" : d9Var.getString(R.string.obfuscated_res_0x7f0f09d7);
                    } else {
                        content = d9Var.getString(R.string.obfuscated_res_0x7f0f09dc);
                    }
                }
                if (chatMessage == null && chatMessage.getToUserInfo() != null) {
                    if (TextUtils.equals(chatMessage.getToUserInfo().getUserId(), String.valueOf(TbadkCoreApplication.getCurrentAccountId()))) {
                        string = d9Var.getString(R.string.obfuscated_res_0x7f0f0eff);
                    } else {
                        string = d9Var.getString(R.string.obfuscated_res_0x7f0f0efc);
                    }
                    return string + chatMessage.getToUserInfo().getUserName() + d9Var.getString(R.string.obfuscated_res_0x7f0f0efd) + content;
                }
                return d9Var.getString(R.string.obfuscated_res_0x7f0f0efc);
            }
            content = chatMessage.getContent();
            if (chatMessage == null) {
            }
            return d9Var.getString(R.string.obfuscated_res_0x7f0f0efc);
        }
        return (String) invokeLL.objValue;
    }
}
