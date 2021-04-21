package d.b.j0.f1.b.q;

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
import d.b.j0.e1.f.h;
/* loaded from: classes4.dex */
public class a {
    public static final String i = "d.b.j0.f1.b.q.a";

    /* renamed from: a  reason: collision with root package name */
    public View f56362a;

    /* renamed from: b  reason: collision with root package name */
    public HeadImageView f56363b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f56364c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f56365d;

    /* renamed from: e  reason: collision with root package name */
    public TbRichTextView f56366e;

    /* renamed from: f  reason: collision with root package name */
    public View f56367f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f56368g;

    /* renamed from: h  reason: collision with root package name */
    public int f56369h = 3;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup, View.OnClickListener onClickListener) {
        this.f56368g = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.official_notification_text_item, viewGroup, false);
        this.f56362a = inflate;
        HeadImageView headImageView = (HeadImageView) inflate.findViewById(R.id.iv_head);
        this.f56363b = headImageView;
        headImageView.setIsRound(true);
        this.f56363b.setOnClickListener(onClickListener);
        this.f56363b.setPlaceHolder(1);
        TextView textView = (TextView) this.f56362a.findViewById(R.id.tv_user_name);
        this.f56364c = textView;
        textView.setOnClickListener(onClickListener);
        this.f56365d = (TextView) this.f56362a.findViewById(R.id.tv_date);
        TbRichTextView tbRichTextView = (TbRichTextView) this.f56362a.findViewById(R.id.tv_content);
        this.f56366e = tbRichTextView;
        tbRichTextView.setTextSize(tbPageContext.getResources().getDimension(R.dimen.tbfontsize42));
        d.b.i0.b1.m.a layoutStrategy = this.f56366e.getLayoutStrategy();
        layoutStrategy.o(tbPageContext.getResources().getDimension(R.dimen.tbds12), 1.0f);
        this.f56366e.setLayoutStrategy(layoutStrategy);
        this.f56366e.setClickable(true);
        this.f56366e.setFocusable(true);
        this.f56367f = this.f56362a.findViewById(R.id.bottom_line);
        b();
    }

    public View a() {
        return this.f56362a;
    }

    public void b() {
        if (this.f56369h != TbadkCoreApplication.getInst().getSkinType()) {
            SkinManager.setBackgroundColor(this.f56362a, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.f56364c, R.color.CAM_X0106);
            SkinManager.setViewTextColor(this.f56365d, R.color.CAM_X0109);
            this.f56366e.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.f56366e.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            SkinManager.setBackgroundColor(this.f56367f, R.color.CAM_X0204);
            this.f56369h = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public void c(ChatMessage chatMessage) {
        if (chatMessage.getUserInfo() != null) {
            this.f56363b.setUserId(chatMessage.getUserInfo().getUserId());
            this.f56363b.W(chatMessage.getUserInfo().getPortrait(), 12, false);
            this.f56365d.setText(StringHelper.getFormatTimeShort(chatMessage.getTime() * 1000));
            TbPageContext tbPageContext = this.f56368g;
            if (tbPageContext == null || this.f56366e == null) {
                return;
            }
            h.e(tbPageContext.getContext(), this.f56366e, chatMessage, i, 0);
            if (chatMessage == null || chatMessage.getContent() == null) {
                return;
            }
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str : split) {
                stringBuffer.append(str);
            }
            this.f56366e.setContentDescription(stringBuffer.toString());
            this.f56366e.getTextView().setContentDescription(stringBuffer.toString());
        }
    }
}
