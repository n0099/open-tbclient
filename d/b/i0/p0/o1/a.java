package d.b.i0.p0.o1;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.SaveDraftDialogView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.SerializableItemInfo;
import com.google.gson.Gson;
import d.b.b.e.m.g;
import d.b.b.e.p.l;
import d.b.h0.r.s.j;
import d.b.i0.c3.y;
/* loaded from: classes4.dex */
public abstract class a implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public final BaseFragmentActivity f58245e;

    /* renamed from: f  reason: collision with root package name */
    public final ForumWriteData f58246f;

    /* renamed from: g  reason: collision with root package name */
    public View f58247g;

    /* renamed from: h  reason: collision with root package name */
    public NavigationBar f58248h;
    public TextView i;
    public View j;
    public TextView k;
    public SerializableItemInfo l;
    public final c m;
    public Gson n = new Gson();
    public j o;
    public SaveDraftDialogView p;

    /* renamed from: d.b.i0.p0.o1.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1417a implements View.OnClickListener {
        public View$OnClickListenerC1417a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == null) {
                return;
            }
            int id = view.getId();
            if (id == R.id.save_draft_dialog_not_save) {
                a.this.b();
                a.this.f58245e.finish();
            } else if (id == R.id.save_draft_dialog_save) {
                a.this.l();
                a.this.f58245e.finish();
            }
            a.this.o.dismiss();
        }
    }

    public a(BaseFragmentActivity baseFragmentActivity, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        this.f58245e = baseFragmentActivity;
        this.f58246f = forumWriteData;
        this.l = serializableItemInfo;
        this.m = new c(baseFragmentActivity, baseFragmentActivity.getUniqueId(), this.f58246f, this.l);
        f();
        e();
        h();
    }

    public void b() {
        ForumWriteData forumWriteData = this.f58246f;
        if (forumWriteData == null) {
            return;
        }
        y.s(String.valueOf(forumWriteData.forumId), null);
    }

    public abstract void c();

    public View d() {
        return this.f58247g;
    }

    public void e() {
        if (this.f58248h == null) {
            return;
        }
        TextView textView = new TextView(this.f58245e);
        this.k = textView;
        textView.setAlpha(0.5f);
        this.k.setText(this.f58245e.getString(R.string.send_post));
        this.k.setTextSize(0, l.g(this.f58245e, R.dimen.tbds44));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.rightMargin = l.g(this.f58245e, R.dimen.tbds44);
        this.k.setLayoutParams(layoutParams);
        this.f58248h.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.k, this);
        TextView centerTextTitle = this.f58248h.setCenterTextTitle(this.f58245e.getString(R.string.publish_comment));
        this.i = centerTextTitle;
        centerTextTitle.setTextSize(0, l.g(this.f58245e, R.dimen.tbds44));
        this.j = this.f58248h.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    public abstract void f();

    public abstract void h();

    public void i(int i, int i2, Intent intent) {
    }

    public void j() {
        SkinManager.setBackgroundColor(this.f58247g, R.color.CAM_X0201);
        TextView textView = this.i;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
        }
        TextView textView2 = this.k;
        if (textView2 != null) {
            SkinManager.setViewTextColor(textView2, R.color.CAM_X0304);
        }
        NavigationBar navigationBar = this.f58248h;
        if (navigationBar != null) {
            navigationBar.onBackBtnOnChangeSkin();
        }
    }

    public void k() {
        g.a(this.o, this.f58245e);
    }

    public abstract void l();

    public void m() {
        if (this.p == null) {
            this.p = new SaveDraftDialogView(this.f58245e);
            this.p.setOnClickListener(new View$OnClickListenerC1417a());
        }
        if (this.o == null) {
            j jVar = new j(this.f58245e.getPageContext());
            this.o = jVar;
            jVar.setContentView(this.p);
        }
        this.p.setText(this.f58245e.getString(R.string.write_save_draft_dialog_normal_title), null, this.f58245e.getString(R.string.save));
        this.o.l();
    }
}
