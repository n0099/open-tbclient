package d.a.n0.l.f;

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
import d.a.c.e.p.l;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final Context f53261a;

    /* renamed from: b  reason: collision with root package name */
    public final View f53262b;

    /* renamed from: c  reason: collision with root package name */
    public final ThreadAchievementShareInfo.ParamBean f53263c;

    /* renamed from: d  reason: collision with root package name */
    public TbRichTextView f53264d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.b1.m.a f53265e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f53266f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f53267g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f53268h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f53269i;
    public TextView j;
    public TextView k;

    public b(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
        this.f53261a = context;
        this.f53262b = LayoutInflater.from(context).inflate(R.layout.normal_interaction_achievement, (ViewGroup) null);
        this.f53263c = threadAchievementShareInfo.getParams();
        c();
        b();
    }

    public View a() {
        return this.f53262b;
    }

    public final void b() {
        if (this.f53263c.getContent() == null || this.f53263c.getContent().size() == 0) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        ThreadAchievementShareInfo.ContentBean contentBean = null;
        for (ThreadAchievementShareInfo.ContentBean contentBean2 : this.f53263c.getContent()) {
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
        if (!TextUtils.isEmpty(this.f53263c.getThread_title())) {
            this.f53267g.setText(this.f53263c.getThread_title());
            this.f53267g.setVisibility(0);
            this.f53264d.setMaxLines(6);
        } else {
            ((LinearLayout.LayoutParams) this.f53264d.getLayoutParams()).topMargin = l.g(this.f53261a, R.dimen.tbds20);
            this.f53264d.setMaxLines(8);
        }
        this.f53264d.setTextEllipsize(TextUtils.TruncateAt.END);
        this.f53264d.setMinimumHeight(l.g(this.f53261a, R.dimen.tbds516));
        if (contentBean != null && !TextUtils.isEmpty(contentBean.getSrc()) && this.f53263c.getThread_type().contains("pic")) {
            this.f53266f.setVisibility(0);
            this.f53266f.setDefaultBgResource(R.color.transparent);
            this.f53266f.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f53266f.setPlaceHolder(2);
            this.f53266f.U(contentBean.getSrc(), 10, false);
            if (!TextUtils.isEmpty(this.f53263c.getThread_title())) {
                this.f53264d.setVisibility(8);
            } else {
                this.f53264d.setMaxLines(2);
                this.f53264d.setTextEllipsize(TextUtils.TruncateAt.END);
                this.f53264d.setLayoutStrategy(this.f53265e);
                this.f53264d.setMinimumHeight(l.g(this.f53261a, R.dimen.tbds0));
            }
        }
        this.f53264d.setText(TbRichTextView.S(this.f53261a, jSONArray, false));
        this.k.setText(StringHelper.numFormatOverWanWithNegative(this.f53263c.getAgree_num()));
        this.f53268h.setText(StringHelper.numFormatOverWanWithNegative(this.f53263c.getPost_num()));
    }

    public final void c() {
        this.f53268h = (TextView) this.f53262b.findViewById(R.id.comment_num);
        this.f53269i = (TextView) this.f53262b.findViewById(R.id.comment_desc);
        this.j = (TextView) this.f53262b.findViewById(R.id.praise_desc);
        this.k = (TextView) this.f53262b.findViewById(R.id.praise_num);
        this.f53267g = (TextView) this.f53262b.findViewById(R.id.thread_title);
        this.f53266f = (TbImageView) this.f53262b.findViewById(R.id.main_img);
        this.f53264d = (TbRichTextView) this.f53262b.findViewById(R.id.rich_text);
        this.k.setTextColor(SkinManager.getColor(R.color.CAM_X0310));
        this.f53268h.setTextColor(SkinManager.getColor(R.color.CAM_X0310));
        this.j.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        this.f53269i.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        this.f53267g.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        d.a.n0.b1.m.a aVar = new d.a.n0.b1.m.a();
        this.f53265e = aVar;
        aVar.s(l.g(this.f53261a, R.dimen.tbds38));
        this.f53265e.v(l.g(this.f53261a, R.dimen.tbds42));
        this.f53265e.j(l.g(this.f53261a, R.dimen.tbds23));
        this.f53265e.o(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12), 1.0f);
        this.f53265e.i(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        this.f53264d.setLayoutStrategy(this.f53265e);
        this.f53264d.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
    }
}
