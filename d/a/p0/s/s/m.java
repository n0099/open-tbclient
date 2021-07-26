package d.a.p0.s.s;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class m extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<n> f53595e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f53596f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f53597g;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f53598a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f53599b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f53600c;

        public b(m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(m mVar, a aVar) {
            this(mVar);
        }
    }

    public m(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f53597g = false;
        this.f53596f = tbPageContext;
        this.f53595e = new ArrayList<>();
    }

    public final boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            ArrayList<n> arrayList = this.f53595e;
            return arrayList != null && i2 == arrayList.size() - 1;
        }
        return invokeI.booleanValue;
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f53597g = z;
        }
    }

    public void c(ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            this.f53595e = arrayList;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f53595e.size() : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? this.f53595e.get(i2) : invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
            n nVar = this.f53595e.get(i2);
            if (nVar == null) {
                return null;
            }
            if (view == null) {
                view = LayoutInflater.from(this.f53596f.getPageActivity()).inflate(R.layout.dialog_rich_bdlist_item, viewGroup, false);
                bVar = new b(this, null);
                bVar.f53598a = (TextView) view.findViewById(R.id.text_tip);
                bVar.f53599b = (TextView) view.findViewById(R.id.text_desc);
                bVar.f53600c = (ImageView) view.findViewById(R.id.checked_icon);
            } else {
                bVar = (b) view.getTag();
            }
            bVar.f53598a.setText(nVar.c());
            if (StringUtils.isNull(nVar.a())) {
                bVar.f53599b.setVisibility(8);
            } else {
                bVar.f53599b.setText(nVar.a());
                bVar.f53599b.setVisibility(0);
            }
            if (nVar.d()) {
                bVar.f53600c.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_set_list_ok_selection26, WebPManager.ResourceStateType.NORMAL));
                bVar.f53600c.setVisibility(0);
            } else if (this.f53597g) {
                WebPManager.setPureDrawable(bVar.f53600c, R.drawable.icon_pure_stroke_n, R.color.CAM_X0111, WebPManager.ResourceStateType.NORMAL);
                bVar.f53600c.setVisibility(0);
            } else {
                bVar.f53600c.setVisibility(4);
            }
            if (a(i2)) {
                SkinManager.setBackgroundResource(view, R.drawable.dialog_single_button_bg_selector);
            } else {
                SkinManager.setBackgroundResource(view, R.drawable.dialg_alert_btn_bg);
            }
            view.setTag(bVar);
            this.f53596f.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.f53596f.getLayoutMode().j(view);
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
