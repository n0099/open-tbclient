package d.a.s0.v1.a;

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
/* loaded from: classes9.dex */
public class b extends d<BubbleChooseActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public NavigationBar f68222a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f68223b;

    /* renamed from: c  reason: collision with root package name */
    public GridView f68224c;

    /* renamed from: d  reason: collision with root package name */
    public View f68225d;

    /* renamed from: e  reason: collision with root package name */
    public a f68226e;

    /* renamed from: f  reason: collision with root package name */
    public BubbleChooseActivity f68227f;

    /* renamed from: g  reason: collision with root package name */
    public ProgressBar f68228g;

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
        this.f68227f = orignalPage;
        orignalPage.setContentView(R.layout.bubble_activity_view);
        NavigationBar navigationBar = (NavigationBar) this.f68227f.findViewById(R.id.lay_title_bar);
        this.f68222a = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f68222a.setTitleText(R.string.editor_privilege);
        this.f68225d = this.f68222a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.bubble_explain, this.f68227f);
        this.f68223b = (ViewGroup) this.f68227f.findViewById(R.id.container);
        this.f68224c = (GridView) this.f68227f.findViewById(R.id.gv_bubble_list);
        a aVar = new a(tbPageContext);
        this.f68226e = aVar;
        this.f68224c.setAdapter((ListAdapter) aVar);
        this.f68228g = (ProgressBar) this.f68227f.findViewById(R.id.bubble_progress);
    }

    public a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f68226e : (a) invokeV.objValue;
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f68225d : (View) invokeV.objValue;
    }

    public GridView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f68224c : (GridView) invokeV.objValue;
    }

    public BubbleListData.BubbleData g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            a aVar = this.f68226e;
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
            this.f68228g.setVisibility(8);
        }
    }

    public void i(List<BubbleListData.BubbleData> list, boolean z) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048581, this, list, z) == null) || (aVar = this.f68226e) == null) {
            return;
        }
        aVar.d(z);
        this.f68226e.c(list);
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f68228g.setVisibility(0);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f68222a.onChangeSkinType((TbPageContext) getPageContext(), i2);
            this.f68227f.getLayoutMode().k(i2 == 1);
            this.f68227f.getLayoutMode().j(this.f68223b);
        }
    }
}
