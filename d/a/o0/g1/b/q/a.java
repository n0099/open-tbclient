package d.a.o0.g1.b.q;

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
import d.a.o0.f1.f.h;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: i  reason: collision with root package name */
    public static final String f58956i = "d.a.o0.g1.b.q.a";

    /* renamed from: a  reason: collision with root package name */
    public View f58957a;

    /* renamed from: b  reason: collision with root package name */
    public HeadImageView f58958b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f58959c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f58960d;

    /* renamed from: e  reason: collision with root package name */
    public TbRichTextView f58961e;

    /* renamed from: f  reason: collision with root package name */
    public View f58962f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f58963g;

    /* renamed from: h  reason: collision with root package name */
    public int f58964h = 3;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup, View.OnClickListener onClickListener) {
        this.f58963g = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.official_notification_text_item, viewGroup, false);
        this.f58957a = inflate;
        HeadImageView headImageView = (HeadImageView) inflate.findViewById(R.id.iv_head);
        this.f58958b = headImageView;
        headImageView.setIsRound(true);
        this.f58958b.setOnClickListener(onClickListener);
        this.f58958b.setPlaceHolder(1);
        TextView textView = (TextView) this.f58957a.findViewById(R.id.tv_user_name);
        this.f58959c = textView;
        textView.setOnClickListener(onClickListener);
        this.f58960d = (TextView) this.f58957a.findViewById(R.id.tv_date);
        TbRichTextView tbRichTextView = (TbRichTextView) this.f58957a.findViewById(R.id.tv_content);
        this.f58961e = tbRichTextView;
        tbRichTextView.setTextSize(tbPageContext.getResources().getDimension(R.dimen.tbfontsize42));
        d.a.n0.b1.m.a layoutStrategy = this.f58961e.getLayoutStrategy();
        layoutStrategy.o(tbPageContext.getResources().getDimension(R.dimen.tbds12), 1.0f);
        this.f58961e.setLayoutStrategy(layoutStrategy);
        this.f58961e.setClickable(true);
        this.f58961e.setFocusable(true);
        this.f58962f = this.f58957a.findViewById(R.id.bottom_line);
        b();
    }

    public View a() {
        return this.f58957a;
    }

    public void b() {
        if (this.f58964h != TbadkCoreApplication.getInst().getSkinType()) {
            SkinManager.setBackgroundColor(this.f58957a, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.f58959c, R.color.CAM_X0106);
            SkinManager.setViewTextColor(this.f58960d, R.color.CAM_X0109);
            this.f58961e.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.f58961e.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            SkinManager.setBackgroundColor(this.f58962f, R.color.CAM_X0204);
            this.f58964h = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public void c(ChatMessage chatMessage) {
        if (chatMessage.getUserInfo() != null) {
            this.f58958b.setUserId(chatMessage.getUserInfo().getUserId());
            this.f58958b.U(chatMessage.getUserInfo().getPortrait(), 12, false);
            this.f58960d.setText(StringHelper.getFormatTimeShort(chatMessage.getTime() * 1000));
            TbPageContext tbPageContext = this.f58963g;
            if (tbPageContext == null || this.f58961e == null) {
                return;
            }
            h.e(tbPageContext.getContext(), this.f58961e, chatMessage, f58956i, 0);
            if (chatMessage == null || chatMessage.getContent() == null) {
                return;
            }
            String[] split = chatMessage.getContent().split("#");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str : split) {
                stringBuffer.append(str);
            }
            this.f58961e.setContentDescription(stringBuffer.toString());
            this.f58961e.getTextView().setContentDescription(stringBuffer.toString());
        }
    }
}
