package d.b.i0.d1.r;

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
import d.b.b.a.d;
/* loaded from: classes3.dex */
public class a extends d<AddGroupActivity> {

    /* renamed from: a  reason: collision with root package name */
    public View f53979a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f53980b;

    /* renamed from: c  reason: collision with root package name */
    public View f53981c;

    /* renamed from: d  reason: collision with root package name */
    public EditText f53982d;

    /* renamed from: e  reason: collision with root package name */
    public ImageButton f53983e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressBar f53984f;

    /* renamed from: g  reason: collision with root package name */
    public View f53985g;

    /* renamed from: h  reason: collision with root package name */
    public View f53986h;
    public AddGroupActivity i;

    /* renamed from: d.b.i0.d1.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1209a implements TextWatcher {
        public C1209a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            a.this.f53985g.setTag(editable.toString().trim());
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (a.this.f53982d.length() > 0) {
                a.this.f53983e.setVisibility(0);
            } else {
                a.this.f53983e.setVisibility(8);
            }
        }
    }

    public a(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        this.f53979a = null;
        this.f53980b = null;
        this.f53981c = null;
        this.f53982d = null;
        this.f53983e = null;
        this.f53984f = null;
        this.f53985g = null;
        this.i = null;
        this.i = addGroupActivity;
        initUI();
    }

    public void g(int i) {
        this.i.getLayoutMode().k(i == 1);
        this.i.getLayoutMode().j(this.f53979a);
        this.f53980b.onChangeSkinType(this.i.getPageContext(), i);
    }

    public void h() {
        EditText editText = this.f53982d;
        if (editText != null) {
            editText.setText("");
        }
    }

    public View i() {
        return this.f53981c;
    }

    public final void initUI() {
        this.i.setContentView(R.layout.im_add_group_activity);
        this.f53979a = this.i.findViewById(R.id.addgroup_rootlayout);
        NavigationBar navigationBar = (NavigationBar) this.i.findViewById(R.id.addgroup_navigationbar);
        this.f53980b = navigationBar;
        this.f53981c = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f53980b.setTitleText(this.i.getResources().getString(R.string.add_group_title_main));
        EditText editText = (EditText) this.i.findViewById(R.id.addgroup_input);
        this.f53982d = editText;
        editText.setInputType(2);
        this.f53983e = (ImageButton) this.i.findViewById(R.id.addgroup_delbtn);
        this.f53985g = this.i.findViewById(R.id.addgroup_searchbutton);
        this.f53986h = this.i.findViewById(R.id.addgroup_vcode);
        this.f53982d.addTextChangedListener(new C1209a());
        this.f53985g = this.i.findViewById(R.id.addgroup_searchbutton);
        this.f53984f = (ProgressBar) this.i.findViewById(R.id.addgroup_progress);
        this.f53981c.setOnClickListener(this.i);
        this.f53983e.setOnClickListener(this.i);
        this.f53985g.setOnClickListener(this.i);
        this.f53986h.setOnClickListener(this.i);
        if (TbadkCoreApplication.getInst().appResponseToCmd(2902030)) {
            return;
        }
        this.f53986h.setVisibility(8);
    }

    public View k() {
        return this.f53983e;
    }

    public View l() {
        return this.f53985g;
    }

    public View m() {
        return this.f53986h;
    }

    public void n(boolean z) {
        this.f53984f.setVisibility(z ? 0 : 8);
    }
}
