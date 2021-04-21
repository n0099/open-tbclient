package d.b.j0.e1.x;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.ValidateItemData;
import com.baidu.tieba.im.validate.ValidateActivity;
/* loaded from: classes4.dex */
public class b extends d.b.c.a.c<ValidateActivity> {

    /* renamed from: b  reason: collision with root package name */
    public View f56019b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f56020c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f56021d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f56022e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f56023f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f56024g;

    /* renamed from: h  reason: collision with root package name */
    public ValidateActivity f56025h;
    public ValidateItemData i;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.f56025h.onItemViewClick(b.this.f56024g, 100, 0, 0L, b.this.i);
        }
    }

    /* renamed from: d.b.j0.e1.x.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1301b implements View.OnClickListener {
        public View$OnClickListenerC1301b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.f56025h.onItemViewClick(b.this.f56020c, 101, 0, 0L, b.this.i);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnLongClickListener {
        public c() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            b.this.f56025h.onItemViewLongClick(b.this.f56019b, 200, 0, 0L, b.this.i);
            return true;
        }
    }

    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), R.layout.validate_item);
        this.f56025h = validateActivity;
        l();
    }

    public void l() {
        View findViewById = this.f42206a.findViewById(R.id.root_view);
        this.f56019b = findViewById;
        HeadImageView headImageView = (HeadImageView) findViewById.findViewById(R.id.iv_head);
        this.f56020c = headImageView;
        headImageView.setIsRound(false);
        this.f56021d = (TextView) this.f56019b.findViewById(R.id.tv_user_name);
        this.f56022e = (TextView) this.f56019b.findViewById(R.id.tv_group_name);
        this.f56023f = (TextView) this.f56019b.findViewById(R.id.tv_apply_reason);
        TextView textView = (TextView) this.f56019b.findViewById(R.id.btn_pass);
        this.f56024g = textView;
        textView.setOnClickListener(new a());
        this.f56020c.setOnClickListener(new View$OnClickListenerC1301b());
        this.f56019b.setOnLongClickListener(new c());
    }

    public void m(ValidateItemData validateItemData) {
        n(validateItemData);
        refresh();
    }

    public void n(ValidateItemData validateItemData) {
        this.i = validateItemData;
    }

    public void refresh() {
        if (this.i == null) {
            return;
        }
        this.f56025h.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        this.f56025h.getLayoutMode().j(this.f56019b);
        String portrait = this.i.getPortrait();
        this.f56020c.setTag(portrait);
        this.f56020c.W(portrait, 12, false);
        if (!TextUtils.isEmpty(this.i.getUserName())) {
            this.f56021d.setText(this.i.getUserName());
        }
        if (!TextUtils.isEmpty(this.i.getGroupName())) {
            TextView textView = this.f56022e;
            textView.setText(this.f56025h.getPageContext().getString(R.string.validate_im_apply_prefix) + this.i.getGroupName());
        }
        if (!TextUtils.isEmpty(this.i.getApplyReason())) {
            TextView textView2 = this.f56023f;
            textView2.setText(this.f56025h.getPageContext().getString(R.string.validate_im_reason_prefix) + this.i.getApplyReason());
        }
        if (this.i.isPass()) {
            this.f56024g.setEnabled(false);
            this.f56024g.setText(this.f56025h.getPageContext().getString(R.string.passed));
            SkinManager.setViewTextColor(this.f56024g, R.color.CAM_X0109);
            this.f56024g.setBackgroundDrawable(null);
        } else {
            this.f56024g.setEnabled(true);
            this.f56024g.setText(this.f56025h.getPageContext().getString(R.string.pass));
        }
        if (this.i.isShown()) {
            return;
        }
        SkinManager.setBackgroundResource(this.f56019b, R.color.common_color_10178);
    }
}
