package d.b.i0.p0.g1;

import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
import d.b.i0.p0.z;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes4.dex */
public class a implements z.d {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f57521a;

    /* renamed from: b  reason: collision with root package name */
    public View f57522b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f57523c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f57524d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f57525e;

    /* renamed from: f  reason: collision with root package name */
    public b f57526f;

    /* renamed from: g  reason: collision with root package name */
    public z f57527g;

    /* renamed from: h  reason: collision with root package name */
    public View f57528h;
    public ImageView i;
    public ImageView j;
    public ImageView k;
    public TextView l;
    public View m;
    public View.OnClickListener n = new View$OnClickListenerC1385a();

    /* renamed from: d.b.i0.p0.g1.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1385a implements View.OnClickListener {
        public View$OnClickListenerC1385a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == a.this.j.getId()) {
                a.this.f57521a.getPageActivity().finish();
            }
        }
    }

    public a(TbPageContext tbPageContext, View view) {
        this.f57521a = tbPageContext;
        this.f57522b = view;
        this.f57523c = (TextView) view.findViewById(R.id.to_user_name);
        this.f57524d = (TextView) view.findViewById(R.id.content);
        this.f57525e = (TextView) view.findViewById(R.id.sender);
        this.f57528h = view.findViewById(R.id.share_view);
        this.i = (ImageView) view.findViewById(R.id.frs_private_share_qrcode);
        ImageView imageView = (ImageView) view.findViewById(R.id.close_button);
        this.j = imageView;
        imageView.setOnClickListener(this.n);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.img_top);
        this.k = imageView2;
        ViewGroup.LayoutParams layoutParams = imageView2.getLayoutParams();
        int k = l.k(tbPageContext.getPageActivity()) - (l.g(tbPageContext.getPageActivity(), R.dimen.tbds49) * 2);
        layoutParams.width = k;
        layoutParams.height = (int) (((k * 364) * 1.0f) / 980.0f);
        this.k.setLayoutParams(layoutParams);
        this.l = (TextView) view.findViewById(R.id.qr_view_intro);
        View findViewById = view.findViewById(R.id.layout_content);
        this.m = findViewById;
        findViewById.setBackground(f());
        this.f57528h.setBackground(f());
        b bVar = new b(tbPageContext);
        this.f57526f = bVar;
        bVar.k();
        i();
        z zVar = new z(tbPageContext);
        this.f57527g = zVar;
        zVar.o(view, this.f57528h, this);
        z zVar2 = this.f57527g;
        b bVar2 = this.f57526f;
        zVar2.q(bVar2.f57531b, bVar2.f57535f);
        this.f57527g.r(5);
    }

    @Override // d.b.i0.p0.z.d
    public void a() {
        this.f57528h.setBackground(new ColorDrawable(SkinManager.getColor(R.color.CAM_X0201)));
        this.k.setImageResource(R.drawable.pic_yaoqinghan_square_corner);
    }

    @Override // d.b.i0.p0.z.d
    public void b() {
        this.f57528h.setBackground(f());
        this.k.setImageResource(R.drawable.pic_yaoqinghan_980x364);
    }

    public final void e(String str) {
        CustomResponsedMessage runTask;
        if (str == null || str.length() == 0 || (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) == null || runTask.getData() == null) {
            return;
        }
        this.i.setImageBitmap((Bitmap) runTask.getData());
    }

    public final GradientDrawable f() {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{SkinManager.getColor(R.color.CAM_X0201), SkinManager.getColor(R.color.CAM_X0201)});
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(l.g(this.f57521a.getPageActivity(), R.dimen.tbds31));
        return gradientDrawable;
    }

    public void g(int i) {
        SkinManager.setImageResource(this.j, R.drawable.icon_popup_shut_n);
        SkinManager.setViewTextColor(this.f57523c, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f57524d, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f57525e, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.l, R.color.CAM_X0109);
    }

    public void h(boolean z) {
        this.f57522b.setVisibility(z ? 0 : 8);
    }

    public final void i() {
        this.f57523c.setText("你好，朋友！");
        this.f57524d.setText(this.f57526f.h());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        Date date = new Date(System.currentTimeMillis());
        TextView textView = this.f57525e;
        textView.setText(this.f57526f.f57533d + "\n" + simpleDateFormat.format(date));
        e(this.f57526f.f57532c);
    }
}
