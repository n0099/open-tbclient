package d.a.q0.u0.n1;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.SaveDraftDialogView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.SerializableItemInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.Gson;
import d.a.d.e.m.g;
import d.a.d.e.p.l;
import d.a.p0.s.s.j;
import d.a.q0.h3.y;
/* loaded from: classes8.dex */
public abstract class a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final BaseFragmentActivity f63949e;

    /* renamed from: f  reason: collision with root package name */
    public final ForumWriteData f63950f;

    /* renamed from: g  reason: collision with root package name */
    public View f63951g;

    /* renamed from: h  reason: collision with root package name */
    public NavigationBar f63952h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f63953i;
    public View j;
    public TextView k;
    public SerializableItemInfo l;
    public final c m;
    public Gson n;
    public j o;
    public SaveDraftDialogView p;

    /* renamed from: d.a.q0.u0.n1.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1702a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f63954e;

        public View$OnClickListenerC1702a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63954e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null) {
                return;
            }
            int id = view.getId();
            if (id == R.id.save_draft_dialog_not_save) {
                this.f63954e.b();
                this.f63954e.f63949e.finish();
            } else if (id == R.id.save_draft_dialog_save) {
                this.f63954e.k();
                this.f63954e.f63949e.finish();
            }
            this.f63954e.o.dismiss();
        }
    }

    public a(BaseFragmentActivity baseFragmentActivity, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity, forumWriteData, serializableItemInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = new Gson();
        this.f63949e = baseFragmentActivity;
        this.f63950f = forumWriteData;
        this.l = serializableItemInfo;
        this.m = new c(baseFragmentActivity, baseFragmentActivity.getUniqueId(), this.f63950f, this.l);
        f();
        e();
        g();
    }

    public void b() {
        ForumWriteData forumWriteData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (forumWriteData = this.f63950f) == null) {
            return;
        }
        y.v(String.valueOf(forumWriteData.forumId), null);
    }

    public abstract void c();

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f63951g : (View) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f63952h == null) {
            return;
        }
        TextView textView = new TextView(this.f63949e);
        this.k = textView;
        textView.setAlpha(0.5f);
        this.k.setText(this.f63949e.getString(R.string.send_post));
        this.k.setTextSize(0, l.g(this.f63949e, R.dimen.tbds44));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.rightMargin = l.g(this.f63949e, R.dimen.tbds44);
        this.k.setLayoutParams(layoutParams);
        this.f63952h.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.k, this);
        TextView centerTextTitle = this.f63952h.setCenterTextTitle(this.f63949e.getString(R.string.publish_comment));
        this.f63953i = centerTextTitle;
        centerTextTitle.setTextSize(0, l.g(this.f63949e, R.dimen.tbds44));
        this.j = this.f63952h.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    public abstract void f();

    public abstract void g();

    public void h(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048582, this, i2, i3, intent) == null) {
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            SkinManager.setBackgroundColor(this.f63951g, R.color.CAM_X0201);
            TextView textView = this.f63953i;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
            }
            TextView textView2 = this.k;
            if (textView2 != null) {
                SkinManager.setViewTextColor(textView2, R.color.CAM_X0304);
            }
            NavigationBar navigationBar = this.f63952h;
            if (navigationBar != null) {
                navigationBar.onBackBtnOnChangeSkin();
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            g.a(this.o, this.f63949e);
        }
    }

    public abstract void k();

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.p == null) {
                this.p = new SaveDraftDialogView(this.f63949e);
                this.p.setOnClickListener(new View$OnClickListenerC1702a(this));
            }
            if (this.o == null) {
                j jVar = new j(this.f63949e.getPageContext());
                this.o = jVar;
                jVar.setContentView(this.p);
            }
            this.p.setText(this.f63949e.getString(R.string.write_save_draft_dialog_normal_title), null, this.f63949e.getString(R.string.save));
            this.o.l();
        }
    }
}
