package d.a.j0.e1.j;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.UpdatesItemData;
import com.baidu.tieba.im.groupUpdates.UpdatesActivity;
import java.util.Date;
/* loaded from: classes4.dex */
public class b extends d.a.c.a.c<UpdatesActivity> {

    /* renamed from: b  reason: collision with root package name */
    public View f53663b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f53664c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f53665d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f53666e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f53667f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f53668g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f53669h;

    /* renamed from: i  reason: collision with root package name */
    public RelativeLayout f53670i;
    public RelativeLayout j;
    public UpdatesActivity k;
    public UpdatesItemData l;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a(b bVar) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* renamed from: d.a.j0.e1.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1225b implements View.OnClickListener {
        public View$OnClickListenerC1225b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.k.isEditMode()) {
                b.this.f53669h.performClick();
            } else {
                b.this.k.onItemViewClick(b.this.f53663b, 101, 0, 0L, b.this.l);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnLongClickListener {
        public c() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            b.this.k.onItemViewLongClick(b.this.f53663b, 200, 0, 0L, b.this.l);
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.k.onItemViewClick(b.this.f53663b, 101, 0, 0L, b.this.l);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnLongClickListener {
        public e() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            b.this.k.onItemViewLongClick(b.this.f53663b, 200, 0, 0L, b.this.l);
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            view.setSelected(!view.isSelected());
            b.this.k.onCheckedChanged(view, view.isSelected(), b.this.l);
        }
    }

    public b(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext(), R.layout.updates_item);
        this.k = updatesActivity;
        k();
    }

    public void k() {
        View findViewById = this.f39391a.findViewById(R.id.root_view);
        this.f53663b = findViewById;
        this.f53664c = (HeadImageView) findViewById.findViewById(R.id.iv_head);
        this.f53665d = (TextView) this.f53663b.findViewById(R.id.tv_group_name);
        this.f53666e = (TextView) this.f53663b.findViewById(R.id.tv_content);
        this.f53667f = (TextView) this.f53663b.findViewById(R.id.tv_title);
        this.f53668g = (TextView) this.f53663b.findViewById(R.id.tv_time);
        this.f53669h = (ImageView) this.f53663b.findViewById(R.id.cb_select);
        this.f53670i = (RelativeLayout) this.f53663b.findViewById(R.id.layout_body);
        this.j = (RelativeLayout) this.f53663b.findViewById(R.id.layout_title);
        this.f53664c.setOnClickListener(new a(this));
        this.f53670i.setClickable(true);
        this.f53670i.setLongClickable(true);
        this.j.setClickable(true);
        this.j.setLongClickable(true);
        this.f53670i.setOnClickListener(new View$OnClickListenerC1225b());
        this.f53670i.setOnLongClickListener(new c());
        this.j.setOnClickListener(new d());
        this.j.setOnLongClickListener(new e());
        this.f53669h.setOnClickListener(new f());
    }

    public void l(UpdatesItemData updatesItemData) {
        m(updatesItemData);
        refresh();
    }

    public void m(UpdatesItemData updatesItemData) {
        this.l = updatesItemData;
    }

    public void refresh() {
        if (this.l == null) {
            return;
        }
        if (this.k.isEditMode()) {
            this.f53669h.setVisibility(0);
        } else {
            this.f53669h.setVisibility(8);
            this.f53670i.setSelected(false);
        }
        String groupHeadUrl = this.l.getGroupHeadUrl();
        if (!TextUtils.isEmpty(groupHeadUrl)) {
            this.f53664c.setTag(groupHeadUrl);
            this.f53664c.V(groupHeadUrl, 10, false);
        } else {
            this.f53664c.setTag(null);
        }
        this.f53664c.setClickable(false);
        if (!TextUtils.isEmpty(this.l.getTitle())) {
            this.f53667f.setText(this.l.getTitle());
        } else {
            this.f53667f.setText(this.k.getPageContext().getString(R.string.inform));
        }
        Date date = new Date();
        date.setTime(this.l.getTime());
        this.f53668g.setText(StringHelper.GetPostTimeString(date));
        if (!TextUtils.isEmpty(this.l.getContent())) {
            this.f53666e.setText(this.l.getContent());
        } else {
            this.f53666e.setText("");
        }
        if (!TextUtils.isEmpty(this.l.getGroupName())) {
            this.f53665d.setText(this.l.getGroupName());
        } else {
            this.f53665d.setText("");
        }
        int paddingLeft = this.f53670i.getPaddingLeft();
        int paddingTop = this.f53670i.getPaddingTop();
        int paddingRight = this.f53670i.getPaddingRight();
        int paddingBottom = this.f53670i.getPaddingBottom();
        this.k.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        this.k.getLayoutMode().j(this.f39391a);
        this.f53669h.setSelected(this.l.isSelected());
        if (this.l.isSelected() && this.k.isEditMode()) {
            SkinManager.setBackgroundResource(this.f53670i, R.drawable.bg_information_down_s);
        } else {
            SkinManager.setBackgroundResource(this.f53670i, R.drawable.selector_group_updates_bottom_bg);
        }
        this.f53670i.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }
}
