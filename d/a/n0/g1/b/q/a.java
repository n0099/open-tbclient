package d.a.n0.g1.b.q;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.chat.ChatMessage;
import d.a.n0.f1.f.h;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: i  reason: collision with root package name */
    public static final String f58831i = "d.a.n0.g1.b.q.a";

    /* renamed from: a  reason: collision with root package name */
    public View f58832a;

    /* renamed from: b  reason: collision with root package name */
    public HeadImageView f58833b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f58834c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f58835d;

    /* renamed from: e  reason: collision with root package name */
    public TbRichTextView f58836e;

    /* renamed from: f  reason: collision with root package name */
    public View f58837f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f58838g;

    /* renamed from: h  reason: collision with root package name */
    public int f58839h = 3;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup, View.OnClickListener onClickListener) {
        this.f58838g = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.official_notification_text_item, viewGroup, false);
        this.f58832a = inflate;
        HeadImageView headImageView = (HeadImageView) inflate.findViewById(R.id.iv_head);
        this.f58833b = headImageView;
        headImageView.setIsRound(true);
        this.f58833b.setOnClickListener(onClickListener);
        this.f58833b.setPlaceHolder(1);
        TextView textView = (TextView) this.f58832a.findViewById(R.id.tv_user_name);
        this.f58834c = textView;
        textView.setOnClickListener(onClickListener);
        this.f58835d = (TextView) this.f58832a.findViewById(R.id.tv_date);
        TbRichTextView tbRichTextView = (TbRichTextView) this.f58832a.findViewById(R.id.tv_content);
        this.f58836e = tbRichTextView;
        tbRichTextView.setTextSize(tbPageContext.getResources().getDimension(R.dimen.tbfontsize42));
        d.a.m0.b1.m.a layoutStrategy = this.f58836e.getLayoutStrategy();
        layoutStrategy.o(tbPageContext.getResources().getDimension(R.dimen.tbds12), 1.0f);
        this.f58836e.setLayoutStrategy(layoutStrategy);
        this.f58836e.setClickable(true);
        this.f58836e.setFocusable(true);
        this.f58837f = this.f58832a.findViewById(R.id.bottom_line);
        b();
    }

    public View a() {
        return this.f58832a;
    }

    public void b() {
        if (this.f58839h != TbadkCoreApplication.getInst().getSkinType()) {
            SkinManager.setBackgroundColor(this.f58832a, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.f58834c, R.color.CAM_X0106);
            SkinManager.setViewTextColor(this.f58835d, R.color.CAM_X0109);
            this.f58836e.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.f58836e.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            SkinManager.setBackgroundColor(this.f58837f, R.color.CAM_X0204);
            this.f58839h = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public void c(ChatMessage chatMessage) {
        if (chatMessage.getUserInfo() != null) {
            this.f58833b.setUserId(chatMessage.getUserInfo().getUserId());
            this.f58833b.U(chatMessage.getUserInfo().getPortrait(), 12, false);
            this.f58835d.setText(StringHelper.getFormatTimeShort(chatMessage.getTime() * 1000));
            TbPageContext tbPageContext = this.f58838g;
            if (tbPageContext == null || this.f58836e == null) {
                return;
            }
            h.e(tbPageContext.getContext(), this.f58836e, chatMessage, f58831i, 0);
            if (chatMessage == null || chatMessage.getContent() == null) {
                return;
            }
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str : split) {
                stringBuffer.append(str);
            }
            this.f58836e.setContentDescription(stringBuffer.toString());
            this.f58836e.getTextView().setContentDescription(stringBuffer.toString());
        }
    }
}
