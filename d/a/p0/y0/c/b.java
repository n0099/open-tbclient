package d.a.p0.y0.c;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.gift.myGiftList.MyGiftListActivity;
import com.baidu.tieba.wallet.CurrencySwitchUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.p0.y0.b.g;
import d.a.p0.y0.c.a;
import java.util.List;
/* loaded from: classes8.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f66364e;

    /* renamed from: f  reason: collision with root package name */
    public List<a.C1851a> f66365f;

    /* renamed from: g  reason: collision with root package name */
    public MyGiftListActivity f66366g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f66367h;

    /* renamed from: i  reason: collision with root package name */
    public NoDataView f66368i;
    public boolean j;
    public int k;
    public View.OnClickListener l;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f66369e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66369e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (j.z()) {
                    this.f66369e.f66366g.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(TbadkApplication.getInst().getContext(), String.valueOf((Long) view.getTag(R.id.tag_first)), (String) view.getTag(R.id.tag_second))));
                    return;
                }
                this.f66369e.f66366g.showToast(R.string.neterror);
            }
        }
    }

    /* renamed from: d.a.p0.y0.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1852b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f66370a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f66371b;

        /* renamed from: c  reason: collision with root package name */
        public HeadImageView f66372c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f66373d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f66374e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f66375f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f66376g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f66377h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f66378i;
        public TextView j;
        public TextView k;

        public C1852b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ C1852b(a aVar) {
            this();
        }
    }

    public b(MyGiftListActivity myGiftListActivity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {myGiftListActivity, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f66364e = 1;
        this.f66367h = false;
        this.k = -1;
        this.l = new a(this);
        this.f66366g = myGiftListActivity;
        this.j = z;
    }

    public final void b(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            this.f66366g.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
            this.f66366g.getLayoutMode().j(view);
        }
    }

    public final View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            NoDataViewFactory.c cVar = null;
            View inflate = LayoutInflater.from(this.f66366g.getPageContext().getPageActivity()).inflate(R.layout.buy_no_face_item, (ViewGroup) null);
            NoDataViewFactory.c a2 = NoDataViewFactory.c.a(new NoDataViewFactory.b(this.f66366g.getResources().getString(R.string.send_gift), this.f66366g.getSendGiftClickListener()));
            this.f66366g.getResources().getDimension(R.dimen.tbds200);
            this.f66366g.getResources().getDimension(R.dimen.ds140);
            String userSex = this.f66366g.getUserSex();
            this.f66366g.getPageContext().getString(R.string.no_gift);
            String string = this.f66366g.getPageContext().getString(R.string.come_on);
            String format = String.format(this.f66366g.getPageContext().getString(R.string.send_him_gift_note), userSex);
            Activity pageActivity = this.f66366g.getPageContext().getPageActivity();
            NoDataViewFactory.d a3 = NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NODATA);
            if (!this.j) {
                string = format;
            }
            NoDataViewFactory.e d2 = NoDataViewFactory.e.d(null, string);
            if (!this.j && TbadkApplication.getInst().isGiftSwitchOn()) {
                cVar = a2;
            }
            this.f66368i = NoDataViewFactory.a(pageActivity, inflate, a3, d2, cVar);
            int skinType = TbadkApplication.getInst().getSkinType();
            this.f66366g.getLayoutMode().k(skinType == 1);
            this.f66366g.getLayoutMode().j(inflate);
            this.f66368i.f(this.f66366g.getPageContext(), skinType);
            this.f66368i.setVisibility(0);
            return inflate;
        }
        return (View) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: d */
    public a.C1851a getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            if (this.f66367h) {
                return null;
            }
            int itemId = (int) getItemId(i2);
            List<a.C1851a> list = this.f66365f;
            if (list == null || list.size() == 0 || itemId < 0 || itemId >= this.f66365f.size()) {
                return null;
            }
            return this.f66365f.get(itemId);
        }
        return (a.C1851a) invokeI.objValue;
    }

    public void e(List<a.C1851a> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, list, i2) == null) {
            if (list != null && list.size() > 0) {
                this.f66367h = false;
            } else {
                this.f66367h = true;
            }
            this.f66365f = list;
            this.k = i2;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f66367h) {
                return 1;
            }
            List<a.C1851a> list = this.f66365f;
            if (list == null || list.size() == 0) {
                return 0;
            }
            return this.f66365f.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        C1852b c1852b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i2, view, viewGroup)) == null) {
            if (this.f66367h) {
                return c();
            }
            if (view != null && view.getTag(R.id.tag_first) != null) {
                c1852b = (C1852b) view.getTag(R.id.tag_first);
            } else {
                view = LayoutInflater.from(this.f66366g.getPageContext().getPageActivity()).inflate(R.layout.my_gift_list_item, viewGroup, false);
                c1852b = new C1852b(null);
                TbImageView tbImageView = (TbImageView) view.findViewById(R.id.item_rank_image);
                c1852b.f66370a = tbImageView;
                tbImageView.setRadius(l.e(this.f66366g.getBaseContext(), 25.0f));
                c1852b.f66371b = (TextView) view.findViewById(R.id.item_rank_text);
                HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.item_portrait);
                c1852b.f66372c = headImageView;
                headImageView.setRadius(l.e(this.f66366g.getBaseContext(), 50.0f));
                c1852b.f66372c.setOnClickListener(this.l);
                c1852b.f66372c.setPlaceHolder(1);
                c1852b.f66373d = (TextView) view.findViewById(R.id.user_name);
                c1852b.f66377h = (TextView) view.findViewById(R.id.gift_num);
                c1852b.f66376g = (TextView) view.findViewById(R.id.gift_value_text);
                c1852b.f66375f = (TextView) view.findViewById(R.id.gift_name);
                c1852b.f66374e = (TextView) view.findViewById(R.id.time);
                c1852b.f66378i = (TextView) view.findViewById(R.id.paly_icon);
                c1852b.j = (TextView) view.findViewById(R.id.reward_prefix);
                c1852b.k = (TextView) view.findViewById(R.id.reward_num);
                view.setTag(R.id.tag_first, c1852b);
            }
            if (!this.j) {
                c1852b.f66374e.setVisibility(8);
                c1852b.f66378i.setVisibility(8);
            } else {
                c1852b.f66378i.setVisibility(0);
            }
            a.C1851a item = getItem(i2);
            if (item != null) {
                if (this.f66366g.userType == 1) {
                    c1852b.f66372c.M(item.f66352c, 12, false);
                    int i3 = item.j;
                    if (i3 == 1) {
                        c1852b.f66370a.setVisibility(0);
                        c1852b.f66370a.setImageResource(R.drawable.icon_frs_no1);
                        c1852b.f66371b.setVisibility(8);
                    } else if (i3 == 2) {
                        c1852b.f66370a.setVisibility(0);
                        c1852b.f66370a.setImageResource(R.drawable.icon_frs_no2);
                        c1852b.f66371b.setVisibility(8);
                    } else if (i3 == 3) {
                        c1852b.f66370a.setVisibility(0);
                        c1852b.f66370a.setImageResource(R.drawable.icon_frs_no3);
                        c1852b.f66371b.setVisibility(8);
                    } else {
                        c1852b.f66370a.setVisibility(8);
                        c1852b.f66371b.setVisibility(0);
                        TextView textView = c1852b.f66371b;
                        textView.setText(item.j + "");
                    }
                } else {
                    c1852b.f66372c.M(item.f66353d, 10, false);
                    c1852b.f66370a.setVisibility(8);
                    c1852b.f66371b.setVisibility(8);
                }
                c1852b.f66372c.setDrawBorder(false);
                c1852b.f66373d.setText(TextUtils.isEmpty(item.k) ? item.f66351b : item.k);
                c1852b.f66372c.setTag(R.id.tag_first, Long.valueOf(item.f66350a));
                c1852b.f66372c.setTag(R.id.tag_second, item.f66351b);
                c1852b.f66375f.setText(this.f66366g.getPageContext().getString(R.string.send_to_you));
                TextView textView2 = c1852b.f66376g;
                textView2.setText(this.f66366g.getPageContext().getString(R.string.gift_value) + item.f66356g);
                if (item.f66355f < 1) {
                    c1852b.f66377h.setVisibility(8);
                } else {
                    TextView textView3 = c1852b.f66377h;
                    textView3.setText(this.f66366g.getPageContext().getString(R.string.mutil_sign) + item.f66355f);
                    c1852b.f66377h.setVisibility(0);
                }
                String formatTime = StringHelper.getFormatTime(item.f66354e * 1000);
                c1852b.f66374e.setText(formatTime);
                if (CurrencySwitchUtil.isYyIsConvert(this.k)) {
                    c1852b.f66374e.setVisibility(8);
                    c1852b.f66376g.setText(formatTime);
                    SkinManager.setViewTextColor(c1852b.f66376g, R.color.CAM_X0109, 1);
                } else {
                    SkinManager.setViewTextColor(c1852b.f66376g, R.color.CAM_X0301, 1);
                }
                c1852b.j.setVisibility(0);
                c1852b.k.setVisibility(0);
                if (item.f66357h > 0) {
                    if (Integer.parseInt(item.f66358i) == 1) {
                        c1852b.k.setText(g.a(item.f66357h, 1, this.k));
                    } else if (Integer.parseInt(item.f66358i) == 2) {
                        c1852b.k.setText(g.a(item.f66357h, 2, this.k));
                    } else {
                        c1852b.j.setVisibility(8);
                        c1852b.k.setVisibility(8);
                    }
                } else {
                    c1852b.j.setVisibility(8);
                    c1852b.k.setVisibility(8);
                }
            }
            b(view);
            return view;
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f66364e : invokeV.intValue;
    }
}
