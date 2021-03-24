package d.b.i0.d1.f;

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
public class d extends d.b.b.a.c<MsglistActivity<?>> {

    /* renamed from: b  reason: collision with root package name */
    public TextView f53640b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f53641c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f53642d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f53643e;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f53644e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f53645f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f53646g;

        public a(long j, String str, String str2) {
            this.f53644e = j;
            this.f53645f = str;
            this.f53646g = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(d.this.mContext.getPageActivity(), String.valueOf(this.f53644e), this.f53645f, this.f53646g, "", false, AddFriendActivityConfig.TYPE_NEW_FRD)));
        }
    }

    public d(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgmid_view);
        this.f53640b = null;
        h();
    }

    public final void h() {
        TextView textView = (TextView) d(R.id.tex_msgcontent);
        this.f53640b = textView;
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        this.f53641c = (LinearLayout) d(R.id.lay_add_friend);
        this.f53642d = (TextView) d(R.id.btn_add_friend);
        this.f53643e = (TextView) d(R.id.text_add_friend);
        this.f53641c.setVisibility(8);
    }

    public final boolean i(ChatMessage chatMessage) {
        UserData toUserInfo;
        if (chatMessage != null && (chatMessage instanceof PersonalChatMessage) && chatMessage.getMsgType() == 11 && !TextUtils.isEmpty(chatMessage.getContent())) {
            try {
                JSONObject jSONObject = new JSONObject(chatMessage.getContent());
                String optString = jSONObject.optString(TbEnum.SystemMessage.KEY_EVENT_ID);
                if (optString != null && optString.equals(TbEnum.SystemMessage.EVENT_ID_ADD_FRIEND)) {
                    this.f53641c.setVisibility(0);
                    this.f53640b.setVisibility(8);
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
                    this.f53643e.setText(optString2);
                    if (optInt == 1) {
                        this.f53642d.setVisibility(0);
                        this.f53642d.setText(optString3);
                        this.f53642d.setOnClickListener(new a(optLong, userName, portrait));
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
        this.f53641c.setVisibility(8);
        if (chatMessage == null) {
            this.f53640b.setText("");
        } else if (i(chatMessage)) {
        } else {
            this.f53640b.setVisibility(0);
            String v = d.b.i0.d1.w.c.v(chatMessage);
            if (!TextUtils.isEmpty(v)) {
                this.f53640b.setText(v);
            } else {
                this.f53640b.setText("");
            }
        }
    }
}
