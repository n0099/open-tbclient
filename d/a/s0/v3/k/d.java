package d.a.s0.v3.k;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.record.VideoEffectLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes9.dex */
public class d extends BaseAdapter implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<e> f68804e;

    /* renamed from: f  reason: collision with root package name */
    public String f68805f;

    /* renamed from: g  reason: collision with root package name */
    public int f68806g;

    /* renamed from: h  reason: collision with root package name */
    public VideoEffectLayout.h f68807h;

    /* loaded from: classes9.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f68808a;

        /* renamed from: b  reason: collision with root package name */
        public ProgressBar f68809b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f68810c;

        /* renamed from: d  reason: collision with root package name */
        public int f68811d;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f68806g = -1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public e getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            List<e> list = this.f68804e;
            if (list != null && i2 >= 0 && i2 < list.size()) {
                return this.f68804e.get(i2);
            }
            return null;
        }
        return (e) invokeI.objValue;
    }

    public final void b(a aVar, View view, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, view, viewGroup) == null) {
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.iv_effect);
            aVar.f68808a = tbImageView;
            tbImageView.setIsRound(true);
            aVar.f68808a.setDrawerType(1);
            aVar.f68808a.setDefaultBgResource(R.color.transparent);
            aVar.f68808a.setBorderWidth(d.a.c.e.p.l.g(viewGroup.getContext(), R.dimen.ds4));
            aVar.f68808a.setConrers(15);
            aVar.f68808a.setBorderColor(SkinManager.getColor(R.color.CAM_X0302));
            aVar.f68810c = (TextView) view.findViewById(R.id.tv_name);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && getItem(0) != null && getItem(0).c() == 3) {
            this.f68806g = 0;
            this.f68805f = TbadkCoreApplication.getInst().getString(R.string.music_normal);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && getItem(0) != null && getItem(0).c() == 3) {
            this.f68806g = 1;
            this.f68805f = TbadkCoreApplication.getInst().getString(R.string.music_cloud);
            notifyDataSetChanged();
        }
    }

    public void e(List<e> list, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, list, str) == null) {
            this.f68804e = list;
            this.f68805f = str;
        }
    }

    public void f(VideoEffectLayout.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, hVar) == null) {
            this.f68807h = hVar;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            List<e> list = this.f68804e;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            e item = getItem(i2);
            if (item == null) {
                return 0;
            }
            int c2 = item.c();
            if (c2 != 1) {
                return c2 != 3 ? 0 : 1;
            }
            return 2;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        a aVar;
        e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048586, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                aVar = new a(this);
                int itemViewType = getItemViewType(i2);
                if (itemViewType == 0) {
                    view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_effect, (ViewGroup) null);
                    b(aVar, view, viewGroup);
                    ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.iv_loading);
                    aVar.f68809b = progressBar;
                    progressBar.setVisibility(4);
                    SkinManager.setViewTextColor(aVar.f68810c, R.color.CAM_X0101);
                } else if (itemViewType == 1) {
                    view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_effect, (ViewGroup) null);
                    b(aVar, view, viewGroup);
                    aVar.f68809b = (ProgressBar) view.findViewById(R.id.iv_loading);
                    aVar.f68808a.setDefaultResource(R.drawable.bg_video_cloudmusic);
                    SkinManager.setViewTextColor(aVar.f68810c, R.color.CAM_X0101);
                } else if (itemViewType == 2) {
                    view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_beauty, (ViewGroup) null);
                    b(aVar, view, viewGroup);
                    SkinManager.setViewTextColor(aVar.f68810c, R.color.CAM_X0101);
                }
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            List<e> list = this.f68804e;
            if (list != null && i2 >= 0 && i2 <= list.size() - 1 && (eVar = this.f68804e.get(i2)) != null) {
                int itemViewType2 = getItemViewType(i2);
                if (itemViewType2 == 0) {
                    aVar.f68808a.M(String.valueOf(eVar.a()), 24, false);
                    if (!TextUtils.isEmpty(eVar.b()) && eVar.b().equals(this.f68805f)) {
                        aVar.f68808a.setDrawBorder(true);
                    } else {
                        aVar.f68808a.setDrawBorder(false);
                    }
                } else if (itemViewType2 == 1) {
                    MusicData musicData = (MusicData) eVar.d();
                    if (musicData.editMusicType == 0) {
                        aVar.f68808a.M(musicData.img, 10, false);
                    } else {
                        aVar.f68808a.M(String.valueOf(eVar.a()), 24, false);
                    }
                    if (this.f68806g != i2) {
                        aVar.f68809b.setVisibility(4);
                    } else if (aVar.f68809b.getVisibility() == 0) {
                        aVar.f68808a.setDrawBorder(false);
                    }
                    if (!TextUtils.isEmpty(eVar.b()) && eVar.b().equals(this.f68805f)) {
                        aVar.f68808a.setDrawBorder(true);
                    } else {
                        aVar.f68808a.setDrawBorder(false);
                    }
                } else if (itemViewType2 == 2) {
                    if (!TextUtils.isEmpty(eVar.b()) && eVar.b().equals(this.f68805f)) {
                        aVar.f68808a.setBackgroundResource(R.drawable.bg_beauty_item_choosed);
                    } else {
                        aVar.f68808a.setBackgroundResource(R.drawable.bg_beauty_item);
                    }
                }
                aVar.f68808a.setTag(eVar);
                aVar.f68808a.setTag(R.id.record_video_effect_holder, aVar);
                aVar.f68808a.setOnClickListener(this);
                aVar.f68810c.setText(eVar.b());
                aVar.f68811d = i2;
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return 3;
        }
        return invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VideoEffectLayout.h hVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, view) == null) && view.getId() == R.id.iv_effect && (view.getTag() instanceof e)) {
            e eVar = (e) view.getTag();
            if (eVar.c() == 3 && (eVar.d() instanceof MusicData)) {
                StatisticItem statisticItem = new StatisticItem("c12423");
                statisticItem.param("obj_id", ((MusicData) eVar.d()).id);
                statisticItem.param("obj_locate", this.f68804e.indexOf(eVar) + 1);
                statisticItem.param("obj_source", 1);
                TiebaStatic.log(statisticItem);
                if (view.getResources().getString(R.string.music_cloud).equals(eVar.b()) && (hVar = this.f68807h) != null) {
                    hVar.onEffectChoosed(eVar, view.getTag(R.id.record_video_effect_holder));
                    this.f68806g = this.f68804e.indexOf(eVar);
                    this.f68805f = eVar.b();
                }
                if (!TextUtils.isEmpty(eVar.b()) && eVar.b().equals(this.f68805f)) {
                    return;
                }
                if (!eVar.b().equals(view.getResources().getString(R.string.music_cloud))) {
                    this.f68806g = this.f68804e.indexOf(eVar);
                }
            } else {
                this.f68806g = this.f68804e.indexOf(eVar);
            }
            this.f68805f = eVar.b();
            notifyDataSetChanged();
            VideoEffectLayout.h hVar2 = this.f68807h;
            if (hVar2 != null) {
                hVar2.onEffectChoosed(eVar, view.getTag(R.id.record_video_effect_holder));
            }
        }
    }
}
