package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.pushNotify.ChatSetting;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes6.dex */
public abstract class g57 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public List<ImMessageCenterShowItemData> b;
    public boolean c;

    /* loaded from: classes6.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ViewGroup a;
        public HeadImageView b;
        public ImageView c;
        public BarImageView d;
        public TextView e;
        public TextView f;
        public TextView g;
        public MessageRedDotView h;
        public View i;
        public ImageView j;
        public ImageView k;
        public ImageView l;

        public a(g57 g57Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g57Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = null;
            this.b = null;
            this.e = null;
            this.f = null;
            this.g = null;
            this.h = null;
            this.i = null;
            this.j = null;
            this.k = null;
            this.l = null;
        }
    }

    public g57(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = false;
        this.a = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public ImMessageCenterShowItemData getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            List<ImMessageCenterShowItemData> list = this.b;
            if (list == null || list.size() == 0 || i < 0 || i >= getCount()) {
                return null;
            }
            return this.b.get(i);
        }
        return (ImMessageCenterShowItemData) invokeI.objValue;
    }

    public a b(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2)) == null) {
            a aVar = new a(this);
            aVar.a = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f090602);
            aVar.c = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091dd8);
            aVar.b = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f090601);
            aVar.d = (BarImageView) view2.findViewById(R.id.obfuscated_res_0x7f090a48);
            aVar.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090607);
            aVar.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09119d);
            aVar.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090608);
            aVar.i = view2.findViewById(R.id.obfuscated_res_0x7f09124a);
            MessageRedDotView messageRedDotView = (MessageRedDotView) view2.findViewById(R.id.obfuscated_res_0x7f091547);
            aVar.h = messageRedDotView;
            messageRedDotView.setShadowEnabled(false);
            aVar.j = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090fbe);
            aVar.k = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091c84);
            aVar.l = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091c77);
            aVar.b.setPlaceHolder(1);
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.c : invokeV.booleanValue;
    }

    public abstract boolean d(ImMessageCenterShowItemData imMessageCenterShowItemData);

    public abstract boolean e(ImMessageCenterShowItemData imMessageCenterShowItemData);

    public void f(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, aVar, imMessageCenterShowItemData) == null) || aVar == null) {
            return;
        }
        if (imMessageCenterShowItemData == null) {
            aVar.j.setVisibility(8);
        } else if (d(imMessageCenterShowItemData)) {
            ChatSetting groupSetting = imMessageCenterShowItemData.getGroupSetting();
            if (groupSetting == null) {
                aVar.j.setVisibility(8);
            } else if (!groupSetting.isAcceptNotify()) {
                aVar.j.setVisibility(0);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(aVar.j, R.drawable.obfuscated_res_0x7f080612, R.color.CAM_X0111, SvgManager.SvgResourceStateType.NORMAL);
            } else {
                aVar.j.setVisibility(8);
            }
        } else {
            aVar.j.setVisibility(8);
        }
    }

    public abstract void g(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData);

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            List<ImMessageCenterShowItemData> list = this.b;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) ? i : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048586, this, i, view2, viewGroup)) == null) {
            a aVar = (view2 == null || !(view2.getTag() instanceof a)) ? null : (a) view2.getTag();
            if (aVar == null) {
                view2 = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d01dc, viewGroup, false);
                aVar = b(view2);
                view2.setTag(aVar);
            }
            SkinManager.setBackgroundResource(view2, R.drawable.list_item_selector);
            SkinManager.setBackgroundResource(aVar.i, R.color.CAM_X0205);
            aVar.a.setVisibility(0);
            ImMessageCenterShowItemData item = getItem(i);
            if (item != null) {
                i(aVar, item);
                h(aVar, item);
                k(aVar, item);
                l(aVar, item);
                g(aVar, item);
                m(aVar, item);
                f(aVar, item);
                j(aVar, item);
                q(item);
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }

    public void h(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, aVar, imMessageCenterShowItemData) == null) {
            if (TextUtils.isEmpty(imMessageCenterShowItemData.getMsgContent())) {
                aVar.f.setText("");
            } else {
                aVar.f.setText(imMessageCenterShowItemData.getMsgContent());
            }
        }
    }

    public void i(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, aVar, imMessageCenterShowItemData) == null) || imMessageCenterShowItemData == null) {
            return;
        }
        aVar.e.setText(imMessageCenterShowItemData.getFriendNameShow());
    }

    public void j(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, aVar, imMessageCenterShowItemData) == null) {
            if (this.c) {
                aVar.l.setVisibility(0);
                if (imMessageCenterShowItemData.isSelected()) {
                    SkinManager.setBackgroundResource(aVar.l, R.drawable.btn_bgb_choice_s);
                    SkinManager.setBackgroundColor(aVar.a, R.color.CAM_X0205);
                    return;
                }
                SkinManager.setBackgroundResource(aVar.l, R.drawable.btn_bgb_choice_n);
                SkinManager.setBackgroundColor(aVar.a, R.color.CAM_X0205);
                return;
            }
            aVar.l.setVisibility(8);
            TBSelector.setViewBackgroundColorWithPressedState(aVar.a, R.color.CAM_X0205, R.color.CAM_X0204);
        }
    }

    public void k(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048590, this, aVar, imMessageCenterShowItemData) == null) || aVar == null || imMessageCenterShowItemData == null || imMessageCenterShowItemData.getOwnerName() == null) {
            return;
        }
        if (e(imMessageCenterShowItemData)) {
            aVar.k.setVisibility(0);
            if (imMessageCenterShowItemData.getSendStatus() == 2) {
                SkinManager.setBackgroundResource(aVar.k, R.drawable.icon_send_failed_information);
                return;
            } else if (imMessageCenterShowItemData.getSendStatus() == 1) {
                SkinManager.setBackgroundResource(aVar.k, R.drawable.icon_send_in_information);
                return;
            } else {
                aVar.k.setVisibility(8);
                return;
            }
        }
        aVar.k.setVisibility(8);
    }

    public void l(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048591, this, aVar, imMessageCenterShowItemData) == null) || aVar == null || imMessageCenterShowItemData == null) {
            return;
        }
        Date date = new Date();
        date.setTime(imMessageCenterShowItemData.getServerTime());
        aVar.g.setText(imMessageCenterShowItemData.getServerTime() != 0 ? StringHelper.getChatTimeString(date) : "");
    }

    public void m(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, aVar, imMessageCenterShowItemData) == null) {
            int unReadCount = imMessageCenterShowItemData.getUnReadCount();
            if (unReadCount > 0) {
                if (zx4.d().e() == 0) {
                    unReadCount = 0;
                } else {
                    BasicNameValuePair p = p(imMessageCenterShowItemData, unReadCount, String.valueOf(unReadCount));
                    if (p != null && p.getName() != null && p.getName().length() > 0) {
                        unReadCount = mg.e(p.getName(), 0);
                    }
                }
                aVar.h.setThreeDotMode(2);
                aVar.h.f(unReadCount);
                aVar.h.setVisibility(0);
            } else {
                aVar.h.setVisibility(8);
            }
            SkinManager.setViewTextColor(aVar.e, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(aVar.f, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(aVar.g, R.color.CAM_X0109, 1);
        }
    }

    public void n(List<ImMessageCenterShowItemData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, list) == null) {
            if (this.b == null) {
                this.b = new LinkedList();
            }
            this.b = list;
            notifyDataSetChanged();
        }
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.c = z;
        }
    }

    public abstract BasicNameValuePair p(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, String str);

    public final void q(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, imMessageCenterShowItemData) == null) || imMessageCenterShowItemData == null) {
            return;
        }
        int i = 0;
        if (TextUtils.equals("4", imMessageCenterShowItemData.getOwnerName())) {
            i = 1;
        } else if (TextUtils.equals("7", imMessageCenterShowItemData.getOwnerName())) {
            i = 2;
        }
        if (i > 0) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_MESSGAE_ITEM_SHOW).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", imMessageCenterShowItemData.getUnReadCount() > 0 ? 1 : 2).param("obj_locate", i).param("obj_param1", imMessageCenterShowItemData.getUnReadCount()));
        }
    }
}
