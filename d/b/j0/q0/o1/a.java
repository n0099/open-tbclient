package d.b.j0.q0.o1;

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
import d.b.c.e.m.g;
import d.b.c.e.p.l;
import d.b.i0.r.s.j;
import d.b.j0.d3.y;
/* loaded from: classes4.dex */
public abstract class a implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public final BaseFragmentActivity f60205e;

    /* renamed from: f  reason: collision with root package name */
    public final ForumWriteData f60206f;

    /* renamed from: g  reason: collision with root package name */
    public View f60207g;

    /* renamed from: h  reason: collision with root package name */
    public NavigationBar f60208h;
    public TextView i;
    public View j;
    public TextView k;
    public SerializableItemInfo l;
    public final c m;
    public Gson n = new Gson();
    public j o;
    public SaveDraftDialogView p;

    /* renamed from: d.b.j0.q0.o1.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1497a implements View.OnClickListener {
        public View$OnClickListenerC1497a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == null) {
                return;
            }
            int id = view.getId();
            if (id == R.id.save_draft_dialog_not_save) {
                a.this.b();
                a.this.f60205e.finish();
            } else if (id == R.id.save_draft_dialog_save) {
                a.this.l();
                a.this.f60205e.finish();
            }
            a.this.o.dismiss();
        }
    }

    public a(BaseFragmentActivity baseFragmentActivity, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        this.f60205e = baseFragmentActivity;
        this.f60206f = forumWriteData;
        this.l = serializableItemInfo;
        this.m = new c(baseFragmentActivity, baseFragmentActivity.getUniqueId(), this.f60206f, this.l);
        f();
        e();
        h();
    }

    public void b() {
        ForumWriteData forumWriteData = this.f60206f;
        if (forumWriteData == null) {
            return;
        }
        y.s(String.valueOf(forumWriteData.forumId), null);
    }

    public abstract void c();

    public View d() {
        return this.f60207g;
    }

    public void e() {
        if (this.f60208h == null) {
            return;
        }
        TextView textView = new TextView(this.f60205e);
        this.k = textView;
        textView.setAlpha(0.5f);
        this.k.setText(this.f60205e.getString(R.string.send_post));
        this.k.setTextSize(0, l.g(this.f60205e, R.dimen.tbds44));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.rightMargin = l.g(this.f60205e, R.dimen.tbds44);
        this.k.setLayoutParams(layoutParams);
        this.f60208h.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.k, this);
        TextView centerTextTitle = this.f60208h.setCenterTextTitle(this.f60205e.getString(R.string.publish_comment));
        this.i = centerTextTitle;
        centerTextTitle.setTextSize(0, l.g(this.f60205e, R.dimen.tbds44));
        this.j = this.f60208h.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    public abstract void f();

    public abstract void h();

    public void i(int i, int i2, Intent intent) {
    }

    public void j() {
        SkinManager.setBackgroundColor(this.f60207g, R.color.CAM_X0201);
        TextView textView = this.i;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
        }
        TextView textView2 = this.k;
        if (textView2 != null) {
            SkinManager.setViewTextColor(textView2, R.color.CAM_X0304);
        }
        NavigationBar navigationBar = this.f60208h;
        if (navigationBar != null) {
            navigationBar.onBackBtnOnChangeSkin();
        }
    }

    public void k() {
        g.a(this.o, this.f60205e);
    }

    public abstract void l();

    public void m() {
        if (this.p == null) {
            this.p = new SaveDraftDialogView(this.f60205e);
            this.p.setOnClickListener(new View$OnClickListenerC1497a());
        }
        if (this.o == null) {
            j jVar = new j(this.f60205e.getPageContext());
            this.o = jVar;
            jVar.setContentView(this.p);
        }
        this.p.setText(this.f60205e.getString(R.string.write_save_draft_dialog_normal_title), null, this.f60205e.getString(R.string.save));
        this.o.l();
    }
}
