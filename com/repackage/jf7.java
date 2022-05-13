package com.repackage;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.location.selectpoi.SelectLocationActivity;
import com.baidu.tieba.tbadkCore.location.LocationData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class jf7 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<Object> a;
    public TbPageContext<SelectLocationActivity> b;
    public boolean c;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public TextView b;
        public ImageView c;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public ImageView b;
        public View c;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    public jf7(TbPageContext<SelectLocationActivity> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = tbPageContext;
        LocationData b2 = yk8.a().b();
        this.c = !yk8.a().d();
        if (b2 == null) {
            return;
        }
        this.a = c(b2.getPoi_info(), b2.getFormatted_address());
    }

    public final View a(View view2, int i, boolean z) {
        InterceptResult invokeCommon;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{view2, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            Object item = getItem(i);
            if (item instanceof LocationData.NearByAddressData) {
                LocationData.NearByAddressData nearByAddressData = (LocationData.NearByAddressData) item;
                if (view2 != null && (view2.getTag() instanceof c)) {
                    bVar = (b) view2.getTag();
                } else {
                    view2 = LayoutInflater.from(this.b.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0750, (ViewGroup) null);
                    bVar = new b(null);
                    bVar.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091cb9);
                    bVar.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091cb7);
                    bVar.c = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091cba);
                    view2.setTag(bVar);
                }
                bVar.b.setText(nearByAddressData.getAddr());
                if (this.c && i == 1) {
                    bVar.c.setVisibility(0);
                    bVar.c.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080907, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL_PRESS));
                    if (TextUtils.isEmpty(nearByAddressData.getAddr())) {
                        bVar.b.setText(R.string.obfuscated_res_0x7f0f10e9);
                    }
                } else {
                    bVar.c.setVisibility(4);
                }
                bVar.a.setText(nearByAddressData.getName());
                this.b.getLayoutMode().k(z);
                this.b.getLayoutMode().j(view2);
                SkinManager.setBackgroundResource(view2, R.drawable.home_recommend_item_bg);
                return view2;
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public final View b(View view2, int i, boolean z) {
        InterceptResult invokeCommon;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view2, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            Object item = getItem(i);
            if (item instanceof String) {
                String str = (String) item;
                if (view2 != null && (view2.getTag() instanceof c)) {
                    cVar = (c) view2.getTag();
                } else {
                    view2 = LayoutInflater.from(this.b.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0751, (ViewGroup) null);
                    cVar = new c(null);
                    cVar.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091cbb);
                    cVar.b = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091cba);
                    cVar.c = view2.findViewById(R.id.obfuscated_res_0x7f091cb8);
                    view2.setTag(cVar);
                }
                if (i == 0 && !this.c) {
                    cVar.b.setVisibility(0);
                    cVar.b.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080907, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL_PRESS));
                } else {
                    cVar.b.setVisibility(4);
                }
                cVar.a.setText(str);
                SkinManager.setBackgroundColor(cVar.c, R.color.CAM_X0204);
                SkinManager.setViewTextColor(cVar.a, R.color.CAM_X0302, 1);
                SkinManager.setBackgroundResource(view2, R.drawable.home_recommend_item_bg);
                return view2;
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public final ArrayList<Object> c(List<LocationData.NearByAddressData> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, list, str)) == null) {
            LocationData.NearByAddressData nearByAddressData = null;
            if (list == null || list.size() <= 0) {
                return null;
            }
            ArrayList<Object> arrayList = new ArrayList<>();
            for (LocationData.NearByAddressData nearByAddressData2 : list) {
                if (nearByAddressData2 != null && !TextUtils.isEmpty(nearByAddressData2.getName())) {
                    if (TextUtils.equals(nearByAddressData2.getName(), str)) {
                        nearByAddressData = nearByAddressData2;
                    } else {
                        arrayList.add(nearByAddressData2);
                    }
                }
            }
            if (nearByAddressData != null) {
                arrayList.add(0, nearByAddressData);
            } else {
                LocationData.NearByAddressData nearByAddressData3 = new LocationData.NearByAddressData();
                nearByAddressData3.setName(str);
                arrayList.add(0, nearByAddressData3);
            }
            TbPageContext<SelectLocationActivity> tbPageContext = this.b;
            if (tbPageContext != null) {
                arrayList.add(0, tbPageContext.getString(R.string.obfuscated_res_0x7f0f10ea));
            }
            return arrayList;
        }
        return (ArrayList) invokeLL.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList<Object> arrayList = this.a;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            ArrayList<Object> arrayList = this.a;
            if (arrayList == null || i < 0 || i >= arrayList.size()) {
                return null;
            }
            return this.a.get(i);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            Object item = getItem(i);
            if (item instanceof String) {
                return 0;
            }
            return item instanceof LocationData.NearByAddressData ? 1 : 2;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i, view2, viewGroup)) == null) {
            int itemViewType = getItemViewType(i);
            boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
            if (itemViewType != 0) {
                if (itemViewType != 1) {
                    return null;
                }
                return a(view2, i, z);
            }
            return b(view2, i, z);
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return 3;
        }
        return invokeV.intValue;
    }
}
