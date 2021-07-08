package d.a.p0.v1.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.bubble.BubbleChooseActivity;
import com.baidu.tieba.memberCenter.bubble.BubbleListData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.d;
import d.a.c.a.f;
import java.util.List;
/* loaded from: classes8.dex */
public class b extends d<BubbleChooseActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public NavigationBar f65004a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f65005b;

    /* renamed from: c  reason: collision with root package name */
    public GridView f65006c;

    /* renamed from: d  reason: collision with root package name */
    public View f65007d;

    /* renamed from: e  reason: collision with root package name */
    public a f65008e;

    /* renamed from: f  reason: collision with root package name */
    public BubbleChooseActivity f65009f;

    /* renamed from: g  reason: collision with root package name */
    public ProgressBar f65010g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(TbPageContext<BubbleChooseActivity> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        BubbleChooseActivity orignalPage = tbPageContext.getOrignalPage();
        this.f65009f = orignalPage;
        orignalPage.setContentView(R.layout.bubble_activity_view);
        NavigationBar navigationBar = (NavigationBar) this.f65009f.findViewById(R.id.lay_title_bar);
        this.f65004a = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f65004a.setTitleText(R.string.editor_privilege);
        this.f65007d = this.f65004a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.bubble_explain, this.f65009f);
        this.f65005b = (ViewGroup) this.f65009f.findViewById(R.id.container);
        this.f65006c = (GridView) this.f65009f.findViewById(R.id.gv_bubble_list);
        a aVar = new a(tbPageContext);
        this.f65008e = aVar;
        this.f65006c.setAdapter((ListAdapter) aVar);
        this.f65010g = (ProgressBar) this.f65009f.findViewById(R.id.bubble_progress);
    }

    public a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f65008e : (a) invokeV.objValue;
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f65007d : (View) invokeV.objValue;
    }

    public GridView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f65006c : (GridView) invokeV.objValue;
    }

    public BubbleListData.BubbleData g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            a aVar = this.f65008e;
            if (aVar == null) {
                return null;
            }
            return aVar.getItem(i2);
        }
        return (BubbleListData.BubbleData) invokeI.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f65010g.setVisibility(8);
        }
    }

    public void j(List<BubbleListData.BubbleData> list, boolean z) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048581, this, list, z) == null) || (aVar = this.f65008e) == null) {
            return;
        }
        aVar.d(z);
        this.f65008e.c(list);
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f65010g.setVisibility(0);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f65004a.onChangeSkinType((TbPageContext) getPageContext(), i2);
            this.f65009f.getLayoutMode().k(i2 == 1);
            this.f65009f.getLayoutMode().j(this.f65005b);
        }
    }
}
