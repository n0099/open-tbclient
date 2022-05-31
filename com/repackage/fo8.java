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
/* loaded from: classes5.dex */
public class fo8 {
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
                return b9Var.getString(R.string.obfuscated_res_0x7f0f0e62);
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
            if (msgType != 1) {
                if (msgType == 2) {
                    content = a(b9Var, chatMessage.getContent());
                } else if (msgType == 3) {
                    content = b9Var.getString(R.string.obfuscated_res_0x7f0f1576);
                } else if (msgType != 30) {
                    if (msgType != 32) {
                        content = msgType != 33 ? "" : b9Var.getString(R.string.obfuscated_res_0x7f0f09d2);
                    } else {
                        content = b9Var.getString(R.string.obfuscated_res_0x7f0f09d7);
                    }
                }
                if (chatMessage == null && chatMessage.getToUserInfo() != null) {
                    if (TextUtils.equals(chatMessage.getToUserInfo().getUserId(), String.valueOf(TbadkCoreApplication.getCurrentAccountId()))) {
                        string = b9Var.getString(R.string.obfuscated_res_0x7f0f0ef4);
                    } else {
                        string = b9Var.getString(R.string.obfuscated_res_0x7f0f0ef1);
                    }
                    return string + chatMessage.getToUserInfo().getUserName() + b9Var.getString(R.string.obfuscated_res_0x7f0f0ef2) + content;
                }
                return b9Var.getString(R.string.obfuscated_res_0x7f0f0ef1);
            }
            content = chatMessage.getContent();
            if (chatMessage == null) {
            }
            return b9Var.getString(R.string.obfuscated_res_0x7f0f0ef1);
        }
        return (String) invokeLL.objValue;
    }
}
