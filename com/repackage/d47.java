package com.repackage;

import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class d47 extends y8<MsglistActivity<?>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView b;
    public LinearLayout c;
    public TextView d;
    public TextView e;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ d47 d;

        public a(d47 d47Var, long j, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d47Var, Long.valueOf(j), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = d47Var;
            this.a = j;
            this.b = str;
            this.c = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(this.d.mContext.getPageActivity(), String.valueOf(this.a), this.b, this.c, "", false, AddFriendActivityConfig.TYPE_NEW_FRD)));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d47(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.obfuscated_res_0x7f0d0551);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((b9) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = null;
        i();
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            TextView textView = (TextView) e(R.id.obfuscated_res_0x7f091f5a);
            this.b = textView;
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            this.c = (LinearLayout) e(R.id.obfuscated_res_0x7f0911b3);
            this.d = (TextView) e(R.id.obfuscated_res_0x7f09040b);
            this.e = (TextView) e(R.id.obfuscated_res_0x7f091f68);
            this.c.setVisibility(8);
        }
    }

    public final boolean j(ChatMessage chatMessage) {
        InterceptResult invokeL;
        UserData toUserInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, chatMessage)) == null) {
            if (chatMessage != null && (chatMessage instanceof PersonalChatMessage) && chatMessage.getMsgType() == 11 && !TextUtils.isEmpty(chatMessage.getContent())) {
                try {
                    JSONObject jSONObject = new JSONObject(chatMessage.getContent());
                    String optString = jSONObject.optString(TbEnum.SystemMessage.KEY_EVENT_ID);
                    if (optString != null && optString.equals(TbEnum.SystemMessage.EVENT_ID_ADD_FRIEND)) {
                        this.c.setVisibility(0);
                        this.b.setVisibility(8);
                        String optString2 = jSONObject.optString(TbEnum.SystemMessage.KEY_USER_MSG);
                        JSONObject optJSONObject = jSONObject.optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
                        if (optJSONObject == null) {
                            return false;
                        }
                        int optInt = optJSONObject.optInt("button_type");
                        String optString3 = optJSONObject.optString("name");
                        long optLong = optJSONObject.optLong("userId");
                        if (chatMessage.getUserId() == optLong) {
                            toUserInfo = chatMessage.getUserInfo();
                        } else {
                            toUserInfo = chatMessage.getToUserInfo();
                        }
                        String userName = toUserInfo.getUserName();
                        String portrait = toUserInfo.getPortrait();
                        this.e.setText(optString2);
                        if (optInt == 1) {
                            this.d.setVisibility(0);
                            this.d.setText(optString3);
                            this.d.setOnClickListener(new a(this, optLong, userName, portrait));
                            return true;
                        }
                    }
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void k(ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, chatMessage) == null) {
            this.c.setVisibility(8);
            if (chatMessage == null) {
                this.b.setText("");
            } else if (j(chatMessage)) {
            } else {
                this.b.setVisibility(0);
                String z = a97.z(chatMessage);
                if (!TextUtils.isEmpty(z)) {
                    this.b.setText(z);
                } else {
                    this.b.setText("");
                }
            }
        }
    }
}
