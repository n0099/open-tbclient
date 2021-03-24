package d.b.i0.l0.y.d;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
/* loaded from: classes4.dex */
public class a extends PopupWindow implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public TextView f56687e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f56688f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f56689g;

    /* renamed from: h  reason: collision with root package name */
    public View f56690h;
    public View i;
    public View j;
    public LinearLayout k;
    public c l;
    public Context m;

    /* renamed from: d.b.i0.l0.y.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnTouchListenerC1329a implements View.OnTouchListener {
        public View$OnTouchListenerC1329a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int top = a.this.f56690h.findViewById(R.id.id_pop_layout).getTop();
            int y = (int) motionEvent.getY();
            if (motionEvent.getAction() == 1 && y < top) {
                a.this.dismiss();
            }
            return true;
        }
    }

    public a(Context context, int i) {
        super(context);
        b(context, i);
        this.m = context;
        e();
        c(TbadkCoreApplication.getInst().getSkinType());
        this.f56687e.setOnClickListener(this);
        this.f56688f.setOnClickListener(this);
        this.f56689g.setOnClickListener(this);
    }

    public final void b(Context context, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.emotion_add_popupwindow, (ViewGroup) null);
        this.f56690h = inflate;
        this.f56687e = (TextView) inflate.findViewById(R.id.tv_single_bar);
        this.f56688f = (TextView) this.f56690h.findViewById(R.id.tv_my_emotion);
        this.f56689g = (TextView) this.f56690h.findViewById(R.id.tv_cancel);
        this.k = (LinearLayout) this.f56690h.findViewById(R.id.id_pop_layout);
        this.i = this.f56690h.findViewById(R.id.line1);
        this.j = this.f56690h.findViewById(R.id.line2);
        if (i == 1) {
            SkinManager.setViewTextColor(this.f56687e, R.color.CAM_X0105);
        } else {
            SkinManager.setViewTextColor(this.f56687e, R.color.CAM_X0204);
        }
    }

    public void c(int i) {
        SkinManager.setBackgroundResource(this.k, R.color.CAM_X0201);
        SkinManager.setBackgroundResource(this.i, R.color.CAM_X0204);
        SkinManager.setBackgroundResource(this.j, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.f56688f, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f56689g, R.color.CAM_X0107);
    }

    public void d(c cVar) {
        this.l = cVar;
    }

    public final void e() {
        if (Build.VERSION.SDK_INT >= 22) {
            setAttachedInDecor(false);
        }
        setContentView(this.f56690h);
        setWidth(-1);
        setHeight(l.i(this.m));
        setFocusable(true);
        setBackgroundDrawable(new ColorDrawable(getContentView().getResources().getColor(R.color.black_alpha50)));
        this.f56690h.setOnTouchListener(new View$OnTouchListenerC1329a());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        dismiss();
        c cVar = this.l;
        if (cVar == null) {
            return;
        }
        if (view == this.f56687e) {
            cVar.b();
        } else if (view == this.f56688f) {
            cVar.a();
        }
    }
}
