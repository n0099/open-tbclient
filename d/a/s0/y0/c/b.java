package d.a.s0.y0.c;

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
import d.a.s0.y0.b.g;
import d.a.s0.y0.c.a;
import java.util.List;
/* loaded from: classes9.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f69561e;

    /* renamed from: f  reason: collision with root package name */
    public List<a.C1892a> f69562f;

    /* renamed from: g  reason: collision with root package name */
    public MyGiftListActivity f69563g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f69564h;

    /* renamed from: i  reason: collision with root package name */
    public NoDataView f69565i;
    public boolean j;
    public int k;
    public View.OnClickListener l;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f69566e;

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
            this.f69566e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (j.z()) {
                    this.f69566e.f69563g.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(TbadkApplication.getInst().getContext(), String.valueOf((Long) view.getTag(R.id.tag_first)), (String) view.getTag(R.id.tag_second))));
                    return;
                }
                this.f69566e.f69563g.showToast(R.string.neterror);
            }
        }
    }

    /* renamed from: d.a.s0.y0.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C1893b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f69567a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f69568b;

        /* renamed from: c  reason: collision with root package name */
        public HeadImageView f69569c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f69570d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f69571e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f69572f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f69573g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f69574h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f69575i;
        public TextView j;
        public TextView k;

        public C1893b() {
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

        public /* synthetic */ C1893b(a aVar) {
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
        this.f69561e = 1;
        this.f69564h = false;
        this.k = -1;
        this.l = new a(this);
        this.f69563g = myGiftListActivity;
        this.j = z;
    }

    public final void b(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            this.f69563g.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
            this.f69563g.getLayoutMode().j(view);
        }
    }

    public final View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            NoDataViewFactory.c cVar = null;
            View inflate = LayoutInflater.from(this.f69563g.getPageContext().getPageActivity()).inflate(R.layout.buy_no_face_item, (ViewGroup) null);
            NoDataViewFactory.c a2 = NoDataViewFactory.c.a(new NoDataViewFactory.b(this.f69563g.getResources().getString(R.string.send_gift), this.f69563g.getSendGiftClickListener()));
            this.f69563g.getResources().getDimension(R.dimen.tbds200);
            this.f69563g.getResources().getDimension(R.dimen.ds140);
            String userSex = this.f69563g.getUserSex();
            this.f69563g.getPageContext().getString(R.string.no_gift);
            String string = this.f69563g.getPageContext().getString(R.string.come_on);
            String format = String.format(this.f69563g.getPageContext().getString(R.string.send_him_gift_note), userSex);
            Activity pageActivity = this.f69563g.getPageContext().getPageActivity();
            NoDataViewFactory.d a3 = NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NODATA);
            if (!this.j) {
                string = format;
            }
            NoDataViewFactory.e d2 = NoDataViewFactory.e.d(null, string);
            if (!this.j && TbadkApplication.getInst().isGiftSwitchOn()) {
                cVar = a2;
            }
            this.f69565i = NoDataViewFactory.a(pageActivity, inflate, a3, d2, cVar);
            int skinType = TbadkApplication.getInst().getSkinType();
            this.f69563g.getLayoutMode().k(skinType == 1);
            this.f69563g.getLayoutMode().j(inflate);
            this.f69565i.f(this.f69563g.getPageContext(), skinType);
            this.f69565i.setVisibility(0);
            return inflate;
        }
        return (View) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: d */
    public a.C1892a getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            if (this.f69564h) {
                return null;
            }
            int itemId = (int) getItemId(i2);
            List<a.C1892a> list = this.f69562f;
            if (list == null || list.size() == 0 || itemId < 0 || itemId >= this.f69562f.size()) {
                return null;
            }
            return this.f69562f.get(itemId);
        }
        return (a.C1892a) invokeI.objValue;
    }

    public void e(List<a.C1892a> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, list, i2) == null) {
            if (list != null && list.size() > 0) {
                this.f69564h = false;
            } else {
                this.f69564h = true;
            }
            this.f69562f = list;
            this.k = i2;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f69564h) {
                return 1;
            }
            List<a.C1892a> list = this.f69562f;
            if (list == null || list.size() == 0) {
                return 0;
            }
            return this.f69562f.size();
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
        C1893b c1893b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i2, view, viewGroup)) == null) {
            if (this.f69564h) {
                return c();
            }
            if (view != null && view.getTag(R.id.tag_first) != null) {
                c1893b = (C1893b) view.getTag(R.id.tag_first);
            } else {
                view = LayoutInflater.from(this.f69563g.getPageContext().getPageActivity()).inflate(R.layout.my_gift_list_item, viewGroup, false);
                c1893b = new C1893b(null);
                TbImageView tbImageView = (TbImageView) view.findViewById(R.id.item_rank_image);
                c1893b.f69567a = tbImageView;
                tbImageView.setRadius(l.e(this.f69563g.getBaseContext(), 25.0f));
                c1893b.f69568b = (TextView) view.findViewById(R.id.item_rank_text);
                HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.item_portrait);
                c1893b.f69569c = headImageView;
                headImageView.setRadius(l.e(this.f69563g.getBaseContext(), 50.0f));
                c1893b.f69569c.setOnClickListener(this.l);
                c1893b.f69569c.setPlaceHolder(1);
                c1893b.f69570d = (TextView) view.findViewById(R.id.user_name);
                c1893b.f69574h = (TextView) view.findViewById(R.id.gift_num);
                c1893b.f69573g = (TextView) view.findViewById(R.id.gift_value_text);
                c1893b.f69572f = (TextView) view.findViewById(R.id.gift_name);
                c1893b.f69571e = (TextView) view.findViewById(R.id.time);
                c1893b.f69575i = (TextView) view.findViewById(R.id.paly_icon);
                c1893b.j = (TextView) view.findViewById(R.id.reward_prefix);
                c1893b.k = (TextView) view.findViewById(R.id.reward_num);
                view.setTag(R.id.tag_first, c1893b);
            }
            if (!this.j) {
                c1893b.f69571e.setVisibility(8);
                c1893b.f69575i.setVisibility(8);
            } else {
                c1893b.f69575i.setVisibility(0);
            }
            a.C1892a item = getItem(i2);
            if (item != null) {
                if (this.f69563g.userType == 1) {
                    c1893b.f69569c.M(item.f69549c, 12, false);
                    int i3 = item.j;
                    if (i3 == 1) {
                        c1893b.f69567a.setVisibility(0);
                        c1893b.f69567a.setImageResource(R.drawable.icon_frs_no1);
                        c1893b.f69568b.setVisibility(8);
                    } else if (i3 == 2) {
                        c1893b.f69567a.setVisibility(0);
                        c1893b.f69567a.setImageResource(R.drawable.icon_frs_no2);
                        c1893b.f69568b.setVisibility(8);
                    } else if (i3 == 3) {
                        c1893b.f69567a.setVisibility(0);
                        c1893b.f69567a.setImageResource(R.drawable.icon_frs_no3);
                        c1893b.f69568b.setVisibility(8);
                    } else {
                        c1893b.f69567a.setVisibility(8);
                        c1893b.f69568b.setVisibility(0);
                        TextView textView = c1893b.f69568b;
                        textView.setText(item.j + "");
                    }
                } else {
                    c1893b.f69569c.M(item.f69550d, 10, false);
                    c1893b.f69567a.setVisibility(8);
                    c1893b.f69568b.setVisibility(8);
                }
                c1893b.f69569c.setDrawBorder(false);
                c1893b.f69570d.setText(TextUtils.isEmpty(item.k) ? item.f69548b : item.k);
                c1893b.f69569c.setTag(R.id.tag_first, Long.valueOf(item.f69547a));
                c1893b.f69569c.setTag(R.id.tag_second, item.f69548b);
                c1893b.f69572f.setText(this.f69563g.getPageContext().getString(R.string.send_to_you));
                TextView textView2 = c1893b.f69573g;
                textView2.setText(this.f69563g.getPageContext().getString(R.string.gift_value) + item.f69553g);
                if (item.f69552f < 1) {
                    c1893b.f69574h.setVisibility(8);
                } else {
                    TextView textView3 = c1893b.f69574h;
                    textView3.setText(this.f69563g.getPageContext().getString(R.string.mutil_sign) + item.f69552f);
                    c1893b.f69574h.setVisibility(0);
                }
                String formatTime = StringHelper.getFormatTime(item.f69551e * 1000);
                c1893b.f69571e.setText(formatTime);
                if (CurrencySwitchUtil.isYyIsConvert(this.k)) {
                    c1893b.f69571e.setVisibility(8);
                    c1893b.f69573g.setText(formatTime);
                    SkinManager.setViewTextColor(c1893b.f69573g, R.color.CAM_X0109, 1);
                } else {
                    SkinManager.setViewTextColor(c1893b.f69573g, R.color.CAM_X0301, 1);
                }
                c1893b.j.setVisibility(0);
                c1893b.k.setVisibility(0);
                if (item.f69554h > 0) {
                    if (Integer.parseInt(item.f69555i) == 1) {
                        c1893b.k.setText(g.a(item.f69554h, 1, this.k));
                    } else if (Integer.parseInt(item.f69555i) == 2) {
                        c1893b.k.setText(g.a(item.f69554h, 2, this.k));
                    } else {
                        c1893b.j.setVisibility(8);
                        c1893b.k.setVisibility(8);
                    }
                } else {
                    c1893b.j.setVisibility(8);
                    c1893b.k.setVisibility(8);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f69561e : invokeV.intValue;
    }
}
