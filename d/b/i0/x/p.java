package d.b.i0.x;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LowFlowsActivityConfig;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class p implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public Context f62277e;

    /* renamed from: f  reason: collision with root package name */
    public View f62278f;

    /* renamed from: g  reason: collision with root package name */
    public View f62279g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f62280h;
    public View i;
    public EMTextView j;
    public ImageView k;
    public int l = 3;
    public String m;

    public p(Context context) {
        this.f62277e = context;
        c(context);
    }

    public ImageView a() {
        return this.k;
    }

    public View b() {
        return this.f62278f;
    }

    public final void c(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.card_low_flows_view, (ViewGroup) null);
        this.f62278f = inflate;
        View findViewById = inflate.findViewById(R.id.root_view);
        this.f62279g = findViewById;
        findViewById.setOnClickListener(this);
        this.f62280h = (ImageView) this.f62278f.findViewById(R.id.img_tb_storehouse);
        this.i = this.f62278f.findViewById(R.id.view_point);
        this.j = (EMTextView) this.f62278f.findViewById(R.id.title_content);
        ImageView imageView = (ImageView) this.f62278f.findViewById(R.id.close);
        this.k = imageView;
        imageView.setClickable(true);
        e(TbadkCoreApplication.getInst().getSkinType());
    }

    public void d() {
        if (StringUtils.isNull(TbSingleton.getInstance().getBannerText())) {
            return;
        }
        this.j.setText(TbSingleton.getInstance().getBannerText());
    }

    public void e(int i) {
        if (this.l != i) {
            d.b.h0.r.u.c a2 = d.b.h0.r.u.c.a(this.f62279g);
            a2.h(R.string.J_X06);
            a2.c(R.color.CAM_X0201);
            d.b.h0.r.u.c a3 = d.b.h0.r.u.c.a(this.i);
            a3.h(R.string.J_X03);
            a3.c(R.color.CAM_X0110);
            d.b.h0.r.u.c.a(this.j).n(R.color.CAM_X0108);
            this.k.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_card_close22, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL_PRESS));
            if (i == 4) {
                WebPManager.setMaskDrawable(this.f62280h, R.drawable.pic_tiebatreasure_28_2, WebPManager.ResourceStateType.NORMAL);
            } else if (i == 1) {
                WebPManager.setMaskDrawable(this.f62280h, R.drawable.pic_tiebatreasure_28_1, WebPManager.ResourceStateType.NORMAL);
            } else {
                WebPManager.setMaskDrawable(this.f62280h, R.drawable.pic_tiebatreasure_28, WebPManager.ResourceStateType.NORMAL);
            }
        }
        this.l = i;
    }

    public void f(String str) {
        if ("2".equals(str)) {
            d.b.i0.z0.f.h.a.a("c14079", "0", str);
        }
        if ("1".equals(str)) {
            d.b.i0.z0.f.h.a.a("c14079", StringUtils.isNull(TbSingleton.getInstance().getLFUserTaskId()) ? "0" : TbSingleton.getInstance().getLFUserTaskId(), str);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        HashMap hashMap = new HashMap();
        if ("from_personaize".equals(this.m)) {
            hashMap.put(LowFlowsActivityConfig.LF_USER, TbSingleton.getInstance().getLFUser());
            hashMap.put(LowFlowsActivityConfig.LF_USER_TASKID, TbSingleton.getInstance().getLFUserTaskId());
            d.b.i0.z0.f.h.a.a("c14080", StringUtils.isNull(TbSingleton.getInstance().getLFUserTaskId()) ? "0" : TbSingleton.getInstance().getLFUserTaskId(), "1");
        } else {
            hashMap.put(LowFlowsActivityConfig.LF_USER, "1");
            d.b.i0.z0.f.h.a.a("c14080", "0", "2");
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new d.b.i0.c3.h0.m(this.f62277e, "TreasureTrovePage", hashMap)));
    }

    public void setFrom(String str) {
        this.m = str;
    }
}
