package d.b.i0.l.f;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareInfo;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final Context f51022a;

    /* renamed from: b  reason: collision with root package name */
    public final View f51023b;

    /* renamed from: c  reason: collision with root package name */
    public final ThreadAchievementShareInfo.ParamBean f51024c;

    /* renamed from: d  reason: collision with root package name */
    public TbRichTextView f51025d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.b1.m.a f51026e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f51027f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f51028g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f51029h;
    public TextView i;
    public TextView j;
    public TextView k;

    public b(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
        this.f51022a = context;
        this.f51023b = LayoutInflater.from(context).inflate(R.layout.normal_interaction_achievement, (ViewGroup) null);
        this.f51024c = threadAchievementShareInfo.getParams();
        c();
        b();
    }

    public View a() {
        return this.f51023b;
    }

    public final void b() {
        if (this.f51024c.getContent() == null || this.f51024c.getContent().size() == 0) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        ThreadAchievementShareInfo.ContentBean contentBean = null;
        for (ThreadAchievementShareInfo.ContentBean contentBean2 : this.f51024c.getContent()) {
            if (contentBean2.getType() == 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", "0");
                    jSONObject.put("text", contentBean2.getText());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                jSONArray.put(jSONObject);
            } else if (contentBean2.getType() == 3) {
                contentBean = contentBean2;
            }
        }
        if (!TextUtils.isEmpty(this.f51024c.getThread_title())) {
            this.f51028g.setText(this.f51024c.getThread_title());
            this.f51028g.setVisibility(0);
            this.f51025d.setMaxLines(6);
        } else {
            ((LinearLayout.LayoutParams) this.f51025d.getLayoutParams()).topMargin = l.g(this.f51022a, R.dimen.tbds20);
            this.f51025d.setMaxLines(8);
        }
        this.f51025d.setTextEllipsize(TextUtils.TruncateAt.END);
        this.f51025d.setMinimumHeight(l.g(this.f51022a, R.dimen.tbds516));
        if (contentBean != null && !TextUtils.isEmpty(contentBean.getSrc()) && this.f51024c.getThread_type().contains("pic")) {
            this.f51027f.setVisibility(0);
            this.f51027f.setDefaultBgResource(R.color.transparent);
            this.f51027f.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f51027f.setPlaceHolder(2);
            this.f51027f.W(contentBean.getSrc(), 10, false);
            if (!TextUtils.isEmpty(this.f51024c.getThread_title())) {
                this.f51025d.setVisibility(8);
            } else {
                this.f51025d.setMaxLines(2);
                this.f51025d.setTextEllipsize(TextUtils.TruncateAt.END);
                this.f51025d.setLayoutStrategy(this.f51026e);
                this.f51025d.setMinimumHeight(l.g(this.f51022a, R.dimen.tbds0));
            }
        }
        this.f51025d.setText(TbRichTextView.S(this.f51022a, jSONArray, false));
        this.k.setText(StringHelper.numFormatOverWanWithNegative(this.f51024c.getAgree_num()));
        this.f51029h.setText(StringHelper.numFormatOverWanWithNegative(this.f51024c.getPost_num()));
    }

    public final void c() {
        this.f51029h = (TextView) this.f51023b.findViewById(R.id.comment_num);
        this.i = (TextView) this.f51023b.findViewById(R.id.comment_desc);
        this.j = (TextView) this.f51023b.findViewById(R.id.praise_desc);
        this.k = (TextView) this.f51023b.findViewById(R.id.praise_num);
        this.f51028g = (TextView) this.f51023b.findViewById(R.id.thread_title);
        this.f51027f = (TbImageView) this.f51023b.findViewById(R.id.main_img);
        this.f51025d = (TbRichTextView) this.f51023b.findViewById(R.id.rich_text);
        this.k.setTextColor(SkinManager.getColor(R.color.CAM_X0310));
        this.f51029h.setTextColor(SkinManager.getColor(R.color.CAM_X0310));
        this.j.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        this.i.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        this.f51028g.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        d.b.i0.b1.m.a aVar = new d.b.i0.b1.m.a();
        this.f51026e = aVar;
        aVar.s(l.g(this.f51022a, R.dimen.tbds38));
        this.f51026e.v(l.g(this.f51022a, R.dimen.tbds42));
        this.f51026e.j(l.g(this.f51022a, R.dimen.tbds23));
        this.f51026e.o(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12), 1.0f);
        this.f51026e.i(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        this.f51025d.setLayoutStrategy(this.f51026e);
        this.f51025d.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
    }
}
