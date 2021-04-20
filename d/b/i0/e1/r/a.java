package d.b.i0.e1.r;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.im.searchGroup.AddGroupActivity;
import d.b.c.a.d;
/* loaded from: classes4.dex */
public class a extends d<AddGroupActivity> {

    /* renamed from: a  reason: collision with root package name */
    public View f55501a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f55502b;

    /* renamed from: c  reason: collision with root package name */
    public View f55503c;

    /* renamed from: d  reason: collision with root package name */
    public EditText f55504d;

    /* renamed from: e  reason: collision with root package name */
    public ImageButton f55505e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressBar f55506f;

    /* renamed from: g  reason: collision with root package name */
    public View f55507g;

    /* renamed from: h  reason: collision with root package name */
    public View f55508h;
    public AddGroupActivity i;

    /* renamed from: d.b.i0.e1.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1272a implements TextWatcher {
        public C1272a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            a.this.f55507g.setTag(editable.toString().trim());
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (a.this.f55504d.length() > 0) {
                a.this.f55505e.setVisibility(0);
            } else {
                a.this.f55505e.setVisibility(8);
            }
        }
    }

    public a(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        this.f55501a = null;
        this.f55502b = null;
        this.f55503c = null;
        this.f55504d = null;
        this.f55505e = null;
        this.f55506f = null;
        this.f55507g = null;
        this.i = null;
        this.i = addGroupActivity;
        initUI();
    }

    public void g(int i) {
        this.i.getLayoutMode().k(i == 1);
        this.i.getLayoutMode().j(this.f55501a);
        this.f55502b.onChangeSkinType(this.i.getPageContext(), i);
    }

    public void h() {
        EditText editText = this.f55504d;
        if (editText != null) {
            editText.setText("");
        }
    }

    public View i() {
        return this.f55503c;
    }

    public final void initUI() {
        this.i.setContentView(R.layout.im_add_group_activity);
        this.f55501a = this.i.findViewById(R.id.addgroup_rootlayout);
        NavigationBar navigationBar = (NavigationBar) this.i.findViewById(R.id.addgroup_navigationbar);
        this.f55502b = navigationBar;
        this.f55503c = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f55502b.setTitleText(this.i.getResources().getString(R.string.add_group_title_main));
        EditText editText = (EditText) this.i.findViewById(R.id.addgroup_input);
        this.f55504d = editText;
        editText.setInputType(2);
        this.f55505e = (ImageButton) this.i.findViewById(R.id.addgroup_delbtn);
        this.f55507g = this.i.findViewById(R.id.addgroup_searchbutton);
        this.f55508h = this.i.findViewById(R.id.addgroup_vcode);
        this.f55504d.addTextChangedListener(new C1272a());
        this.f55507g = this.i.findViewById(R.id.addgroup_searchbutton);
        this.f55506f = (ProgressBar) this.i.findViewById(R.id.addgroup_progress);
        this.f55503c.setOnClickListener(this.i);
        this.f55505e.setOnClickListener(this.i);
        this.f55507g.setOnClickListener(this.i);
        this.f55508h.setOnClickListener(this.i);
        if (TbadkCoreApplication.getInst().appResponseToCmd(2902030)) {
            return;
        }
        this.f55508h.setVisibility(8);
    }

    public View k() {
        return this.f55505e;
    }

    public View l() {
        return this.f55507g;
    }

    public View m() {
        return this.f55508h;
    }

    public void n(boolean z) {
        this.f55506f.setVisibility(z ? 0 : 8);
    }
}
