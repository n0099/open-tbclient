package d.a.r0.l.f;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareInfo;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Context f55397a;

    /* renamed from: b  reason: collision with root package name */
    public final View f55398b;

    /* renamed from: c  reason: collision with root package name */
    public final ThreadAchievementShareInfo.ParamBean f55399c;

    /* renamed from: d  reason: collision with root package name */
    public TbRichTextView f55400d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.r0.b1.m.a f55401e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f55402f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f55403g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f55404h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f55405i;
    public TextView j;
    public TextView k;

    public b(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, threadAchievementShareInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f55397a = context;
        this.f55398b = LayoutInflater.from(context).inflate(R.layout.normal_interaction_achievement, (ViewGroup) null);
        this.f55399c = threadAchievementShareInfo.getParams();
        c();
        b();
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f55398b : (View) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f55399c.getContent() == null || this.f55399c.getContent().size() == 0) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        ThreadAchievementShareInfo.ContentBean contentBean = null;
        for (ThreadAchievementShareInfo.ContentBean contentBean2 : this.f55399c.getContent()) {
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
        if (!TextUtils.isEmpty(this.f55399c.getThread_title())) {
            this.f55403g.setText(this.f55399c.getThread_title());
            this.f55403g.setVisibility(0);
            this.f55400d.setMaxLines(6);
        } else {
            ((LinearLayout.LayoutParams) this.f55400d.getLayoutParams()).topMargin = l.g(this.f55397a, R.dimen.tbds20);
            this.f55400d.setMaxLines(8);
        }
        this.f55400d.setTextEllipsize(TextUtils.TruncateAt.END);
        this.f55400d.setMinimumHeight(l.g(this.f55397a, R.dimen.tbds516));
        if (contentBean != null && !TextUtils.isEmpty(contentBean.getSrc()) && this.f55399c.getThread_type().contains("pic")) {
            this.f55402f.setVisibility(0);
            this.f55402f.setDefaultBgResource(R.color.transparent);
            this.f55402f.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f55402f.setPlaceHolder(2);
            this.f55402f.M(contentBean.getSrc(), 10, false);
            if (!TextUtils.isEmpty(this.f55399c.getThread_title())) {
                this.f55400d.setVisibility(8);
            } else {
                this.f55400d.setMaxLines(2);
                this.f55400d.setTextEllipsize(TextUtils.TruncateAt.END);
                this.f55400d.setLayoutStrategy(this.f55401e);
                this.f55400d.setMinimumHeight(l.g(this.f55397a, R.dimen.tbds0));
            }
        }
        this.f55400d.setText(TbRichTextView.S(this.f55397a, jSONArray, false));
        this.k.setText(StringHelper.numFormatOverWanWithNegative(this.f55399c.getAgree_num()));
        this.f55404h.setText(StringHelper.numFormatOverWanWithNegative(this.f55399c.getPost_num()));
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f55404h = (TextView) this.f55398b.findViewById(R.id.comment_num);
            this.f55405i = (TextView) this.f55398b.findViewById(R.id.comment_desc);
            this.j = (TextView) this.f55398b.findViewById(R.id.praise_desc);
            this.k = (TextView) this.f55398b.findViewById(R.id.praise_num);
            this.f55403g = (TextView) this.f55398b.findViewById(R.id.thread_title);
            this.f55402f = (TbImageView) this.f55398b.findViewById(R.id.main_img);
            this.f55400d = (TbRichTextView) this.f55398b.findViewById(R.id.rich_text);
            this.k.setTextColor(SkinManager.getColor(R.color.CAM_X0310));
            this.f55404h.setTextColor(SkinManager.getColor(R.color.CAM_X0310));
            this.j.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.f55405i.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.f55403g.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            d.a.r0.b1.m.a aVar = new d.a.r0.b1.m.a();
            this.f55401e = aVar;
            aVar.s(l.g(this.f55397a, R.dimen.tbds38));
            this.f55401e.v(l.g(this.f55397a, R.dimen.tbds42));
            this.f55401e.j(l.g(this.f55397a, R.dimen.tbds23));
            this.f55401e.o(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12), 1.0f);
            this.f55401e.i(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
            this.f55400d.setLayoutStrategy(this.f55401e);
            this.f55400d.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        }
    }
}
