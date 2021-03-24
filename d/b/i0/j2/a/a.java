package d.b.i0.j2.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pluginCenter.PluginConfigWrapper;
import com.baidu.tieba.pluginCenter.view.CircleProgressBar;
/* loaded from: classes5.dex */
public class a extends d.b.h0.g0.f.a<PluginConfigWrapper, d.b.h0.g0.d.b> {
    public TbImageView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public TextView o;
    public CircleProgressBar p;

    /* renamed from: d.b.i0.j2.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1319a implements View.OnClickListener {
        public View$OnClickListenerC1319a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.h0.g0.c.b bVar = new d.b.h0.g0.c.b(3, a.this.c(), null, null);
            bVar.i(a.this.j());
            a.this.d().dispatchMvcEvent(bVar);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.h0.g0.c.b bVar = new d.b.h0.g0.c.b(2, a.this.c(), null, null);
            bVar.i(a.this.j());
            a.this.d().dispatchMvcEvent(bVar);
        }
    }

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.k = (TbImageView) view.findViewById(R.id.icon);
        this.l = (TextView) view.findViewById(R.id.title);
        this.m = (TextView) view.findViewById(R.id.desc);
        TextView textView = (TextView) view.findViewById(R.id.status);
        this.n = textView;
        textView.setOnClickListener(new View$OnClickListenerC1319a());
        TextView textView2 = (TextView) view.findViewById(R.id.install);
        this.o = textView2;
        textView2.setOnClickListener(new b());
        this.p = (CircleProgressBar) view.findViewById(R.id.install_progress);
    }

    @Override // d.b.i0.c3.t
    public boolean onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        d.b.h0.s0.a.a(tbPageContext, g());
        this.p.setCircleForegroundColor(SkinManager.getColor(R.color.CAM_X0302));
        this.p.setCircleBackgroundColor(SkinManager.getColor(R.color.CAM_X0109));
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.h0.g0.f.e
    /* renamed from: q */
    public void k(PluginConfigWrapper pluginConfigWrapper) {
        super.k(pluginConfigWrapper);
        if (pluginConfigWrapper == null) {
            return;
        }
        if (!StringUtils.isNull(pluginConfigWrapper.icon)) {
            this.k.W(pluginConfigWrapper.icon, 10, false);
        }
        this.l.setText(pluginConfigWrapper.display_name);
        this.m.setText(pluginConfigWrapper.verbose);
        if (PluginPackageManager.O().y(pluginConfigWrapper.package_name)) {
            this.o.setVisibility(8);
            this.p.setVisibility(8);
            this.n.setVisibility(0);
            this.n.setText(R.string.view);
        } else if (pluginConfigWrapper.getDownLoadStatus() == 3) {
            this.p.setProgress(pluginConfigWrapper.getDownLoadPercent());
            this.n.setVisibility(8);
            this.o.setVisibility(8);
            this.p.setVisibility(0);
        } else {
            this.n.setVisibility(8);
            this.o.setVisibility(0);
            this.p.setVisibility(8);
        }
    }
}
