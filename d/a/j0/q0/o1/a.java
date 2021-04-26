package d.a.j0.q0.o1;

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
import d.a.c.e.m.g;
import d.a.c.e.p.l;
import d.a.i0.r.s.j;
import d.a.j0.d3.y;
/* loaded from: classes4.dex */
public abstract class a implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public final BaseFragmentActivity f58287e;

    /* renamed from: f  reason: collision with root package name */
    public final ForumWriteData f58288f;

    /* renamed from: g  reason: collision with root package name */
    public View f58289g;

    /* renamed from: h  reason: collision with root package name */
    public NavigationBar f58290h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f58291i;
    public View j;
    public TextView k;
    public SerializableItemInfo l;
    public final c m;
    public Gson n = new Gson();
    public j o;
    public SaveDraftDialogView p;

    /* renamed from: d.a.j0.q0.o1.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1436a implements View.OnClickListener {
        public View$OnClickListenerC1436a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == null) {
                return;
            }
            int id = view.getId();
            if (id == R.id.save_draft_dialog_not_save) {
                a.this.b();
                a.this.f58287e.finish();
            } else if (id == R.id.save_draft_dialog_save) {
                a.this.k();
                a.this.f58287e.finish();
            }
            a.this.o.dismiss();
        }
    }

    public a(BaseFragmentActivity baseFragmentActivity, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        this.f58287e = baseFragmentActivity;
        this.f58288f = forumWriteData;
        this.l = serializableItemInfo;
        this.m = new c(baseFragmentActivity, baseFragmentActivity.getUniqueId(), this.f58288f, this.l);
        f();
        e();
        g();
    }

    public void b() {
        ForumWriteData forumWriteData = this.f58288f;
        if (forumWriteData == null) {
            return;
        }
        y.s(String.valueOf(forumWriteData.forumId), null);
    }

    public abstract void c();

    public View d() {
        return this.f58289g;
    }

    public void e() {
        if (this.f58290h == null) {
            return;
        }
        TextView textView = new TextView(this.f58287e);
        this.k = textView;
        textView.setAlpha(0.5f);
        this.k.setText(this.f58287e.getString(R.string.send_post));
        this.k.setTextSize(0, l.g(this.f58287e, R.dimen.tbds44));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.rightMargin = l.g(this.f58287e, R.dimen.tbds44);
        this.k.setLayoutParams(layoutParams);
        this.f58290h.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.k, this);
        TextView centerTextTitle = this.f58290h.setCenterTextTitle(this.f58287e.getString(R.string.publish_comment));
        this.f58291i = centerTextTitle;
        centerTextTitle.setTextSize(0, l.g(this.f58287e, R.dimen.tbds44));
        this.j = this.f58290h.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    public abstract void f();

    public abstract void g();

    public void h(int i2, int i3, Intent intent) {
    }

    public void i() {
        SkinManager.setBackgroundColor(this.f58289g, R.color.CAM_X0201);
        TextView textView = this.f58291i;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
        }
        TextView textView2 = this.k;
        if (textView2 != null) {
            SkinManager.setViewTextColor(textView2, R.color.CAM_X0304);
        }
        NavigationBar navigationBar = this.f58290h;
        if (navigationBar != null) {
            navigationBar.onBackBtnOnChangeSkin();
        }
    }

    public void j() {
        g.a(this.o, this.f58287e);
    }

    public abstract void k();

    public void l() {
        if (this.p == null) {
            this.p = new SaveDraftDialogView(this.f58287e);
            this.p.setOnClickListener(new View$OnClickListenerC1436a());
        }
        if (this.o == null) {
            j jVar = new j(this.f58287e.getPageContext());
            this.o = jVar;
            jVar.setContentView(this.p);
        }
        this.p.setText(this.f58287e.getString(R.string.write_save_draft_dialog_normal_title), null, this.f58287e.getString(R.string.save));
        this.o.l();
    }
}
