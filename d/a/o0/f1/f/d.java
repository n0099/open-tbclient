package d.a.o0.f1.f;

import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d extends d.a.c.a.c<MsglistActivity<?>> {

    /* renamed from: b  reason: collision with root package name */
    public TextView f58144b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f58145c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f58146d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f58147e;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f58148e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f58149f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f58150g;

        public a(long j, String str, String str2) {
            this.f58148e = j;
            this.f58149f = str;
            this.f58150g = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(d.this.mContext.getPageActivity(), String.valueOf(this.f58148e), this.f58149f, this.f58150g, "", false, AddFriendActivityConfig.TYPE_NEW_FRD)));
        }
    }

    public d(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgmid_view);
        this.f58144b = null;
        h();
    }

    public final void h() {
        TextView textView = (TextView) d(R.id.tex_msgcontent);
        this.f58144b = textView;
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        this.f58145c = (LinearLayout) d(R.id.lay_add_friend);
        this.f58146d = (TextView) d(R.id.btn_add_friend);
        this.f58147e = (TextView) d(R.id.text_add_friend);
        this.f58145c.setVisibility(8);
    }

    public final boolean i(ChatMessage chatMessage) {
        UserData toUserInfo;
        if (chatMessage != null && (chatMessage instanceof PersonalChatMessage) && chatMessage.getMsgType() == 11 && !TextUtils.isEmpty(chatMessage.getContent())) {
            try {
                JSONObject jSONObject = new JSONObject(chatMessage.getContent());
                String optString = jSONObject.optString(TbEnum.SystemMessage.KEY_EVENT_ID);
                if (optString != null && optString.equals(TbEnum.SystemMessage.EVENT_ID_ADD_FRIEND)) {
                    this.f58145c.setVisibility(0);
                    this.f58144b.setVisibility(8);
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
                    this.f58147e.setText(optString2);
                    if (optInt == 1) {
                        this.f58146d.setVisibility(0);
                        this.f58146d.setText(optString3);
                        this.f58146d.setOnClickListener(new a(optLong, userName, portrait));
                        return true;
                    }
                }
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
        return false;
    }

    public void k(ChatMessage chatMessage) {
        this.f58145c.setVisibility(8);
        if (chatMessage == null) {
            this.f58144b.setText("");
        } else if (i(chatMessage)) {
        } else {
            this.f58144b.setVisibility(0);
            String v = d.a.o0.f1.w.c.v(chatMessage);
            if (!TextUtils.isEmpty(v)) {
                this.f58144b.setText(v);
            } else {
                this.f58144b.setText("");
            }
        }
    }
}
