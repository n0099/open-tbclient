package d.a.j0.e1.x;

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
public class b extends d.a.c.a.c<ValidateActivity> {

    /* renamed from: b  reason: collision with root package name */
    public View f53887b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f53888c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f53889d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f53890e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f53891f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f53892g;

    /* renamed from: h  reason: collision with root package name */
    public ValidateActivity f53893h;

    /* renamed from: i  reason: collision with root package name */
    public ValidateItemData f53894i;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.f53893h.onItemViewClick(b.this.f53892g, 100, 0, 0L, b.this.f53894i);
        }
    }

    /* renamed from: d.a.j0.e1.x.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1240b implements View.OnClickListener {
        public View$OnClickListenerC1240b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.f53893h.onItemViewClick(b.this.f53888c, 101, 0, 0L, b.this.f53894i);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnLongClickListener {
        public c() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            b.this.f53893h.onItemViewLongClick(b.this.f53887b, 200, 0, 0L, b.this.f53894i);
            return true;
        }
    }

    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), R.layout.validate_item);
        this.f53893h = validateActivity;
        l();
    }

    public void l() {
        View findViewById = this.f39391a.findViewById(R.id.root_view);
        this.f53887b = findViewById;
        HeadImageView headImageView = (HeadImageView) findViewById.findViewById(R.id.iv_head);
        this.f53888c = headImageView;
        headImageView.setIsRound(false);
        this.f53889d = (TextView) this.f53887b.findViewById(R.id.tv_user_name);
        this.f53890e = (TextView) this.f53887b.findViewById(R.id.tv_group_name);
        this.f53891f = (TextView) this.f53887b.findViewById(R.id.tv_apply_reason);
        TextView textView = (TextView) this.f53887b.findViewById(R.id.btn_pass);
        this.f53892g = textView;
        textView.setOnClickListener(new a());
        this.f53888c.setOnClickListener(new View$OnClickListenerC1240b());
        this.f53887b.setOnLongClickListener(new c());
    }

    public void m(ValidateItemData validateItemData) {
        n(validateItemData);
        refresh();
    }

    public void n(ValidateItemData validateItemData) {
        this.f53894i = validateItemData;
    }

    public void refresh() {
        if (this.f53894i == null) {
            return;
        }
        this.f53893h.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        this.f53893h.getLayoutMode().j(this.f53887b);
        String portrait = this.f53894i.getPortrait();
        this.f53888c.setTag(portrait);
        this.f53888c.V(portrait, 12, false);
        if (!TextUtils.isEmpty(this.f53894i.getUserName())) {
            this.f53889d.setText(this.f53894i.getUserName());
        }
        if (!TextUtils.isEmpty(this.f53894i.getGroupName())) {
            TextView textView = this.f53890e;
            textView.setText(this.f53893h.getPageContext().getString(R.string.validate_im_apply_prefix) + this.f53894i.getGroupName());
        }
        if (!TextUtils.isEmpty(this.f53894i.getApplyReason())) {
            TextView textView2 = this.f53891f;
            textView2.setText(this.f53893h.getPageContext().getString(R.string.validate_im_reason_prefix) + this.f53894i.getApplyReason());
        }
        if (this.f53894i.isPass()) {
            this.f53892g.setEnabled(false);
            this.f53892g.setText(this.f53893h.getPageContext().getString(R.string.passed));
            SkinManager.setViewTextColor(this.f53892g, R.color.CAM_X0109);
            this.f53892g.setBackgroundDrawable(null);
        } else {
            this.f53892g.setEnabled(true);
            this.f53892g.setText(this.f53893h.getPageContext().getString(R.string.pass));
        }
        if (this.f53894i.isShown()) {
            return;
        }
        SkinManager.setBackgroundResource(this.f53887b, R.color.common_color_10178);
    }
}
