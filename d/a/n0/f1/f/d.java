package d.a.n0.f1.f;

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
    public TextView f58019b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f58020c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f58021d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f58022e;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f58023e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f58024f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f58025g;

        public a(long j, String str, String str2) {
            this.f58023e = j;
            this.f58024f = str;
            this.f58025g = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(d.this.mContext.getPageActivity(), String.valueOf(this.f58023e), this.f58024f, this.f58025g, "", false, AddFriendActivityConfig.TYPE_NEW_FRD)));
        }
    }

    public d(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgmid_view);
        this.f58019b = null;
        h();
    }

    public final void h() {
        TextView textView = (TextView) d(R.id.tex_msgcontent);
        this.f58019b = textView;
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        this.f58020c = (LinearLayout) d(R.id.lay_add_friend);
        this.f58021d = (TextView) d(R.id.btn_add_friend);
        this.f58022e = (TextView) d(R.id.text_add_friend);
        this.f58020c.setVisibility(8);
    }

    public final boolean i(ChatMessage chatMessage) {
        UserData toUserInfo;
        if (chatMessage != null && (chatMessage instanceof PersonalChatMessage) && chatMessage.getMsgType() == 11 && !TextUtils.isEmpty(chatMessage.getContent())) {
            try {
                JSONObject jSONObject = new JSONObject(chatMessage.getContent());
                String optString = jSONObject.optString(TbEnum.SystemMessage.KEY_EVENT_ID);
                if (optString != null && optString.equals(TbEnum.SystemMessage.EVENT_ID_ADD_FRIEND)) {
                    this.f58020c.setVisibility(0);
                    this.f58019b.setVisibility(8);
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
                    this.f58022e.setText(optString2);
                    if (optInt == 1) {
                        this.f58021d.setVisibility(0);
                        this.f58021d.setText(optString3);
                        this.f58021d.setOnClickListener(new a(optLong, userName, portrait));
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
        this.f58020c.setVisibility(8);
        if (chatMessage == null) {
            this.f58019b.setText("");
        } else if (i(chatMessage)) {
        } else {
            this.f58019b.setVisibility(0);
            String v = d.a.n0.f1.w.c.v(chatMessage);
            if (!TextUtils.isEmpty(v)) {
                this.f58019b.setText(v);
            } else {
                this.f58019b.setText("");
            }
        }
    }
}
