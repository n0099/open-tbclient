package d.a.s0.z3.l.h;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.cloudmusic.data.CloudMusicData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.f;
import d.a.c.e.p.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public f f70043e;

    /* renamed from: f  reason: collision with root package name */
    public List<CloudMusicData.MusicTagList.MusicList> f70044f;

    /* renamed from: g  reason: collision with root package name */
    public c f70045g;

    /* renamed from: h  reason: collision with root package name */
    public String f70046h;

    /* renamed from: d.a.s0.z3.l.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class View$OnClickListenerC1918a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CloudMusicData.MusicTagList.MusicList f70047e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f70048f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f70049g;

        public View$OnClickListenerC1918a(a aVar, CloudMusicData.MusicTagList.MusicList musicList, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, musicList, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70049g = aVar;
            this.f70047e = musicList;
            this.f70048f = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f70049g.f70045g == null) {
                return;
            }
            this.f70049g.f70045g.A0(view, this.f70047e.resource, this.f70048f);
        }
    }

    /* loaded from: classes9.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f70050a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f70051b;

        /* renamed from: c  reason: collision with root package name */
        public View f70052c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f70053d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f70054e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f70055f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f70056g;

        /* renamed from: h  reason: collision with root package name */
        public View f70057h;

        public b() {
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

        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                SkinManager.setViewTextColor(this.f70053d, R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.f70054e, R.color.CAM_X0107);
                SkinManager.setViewTextColor(this.f70055f, R.color.CAM_X0107);
                SkinManager.setViewTextColor(this.f70056g, R.color.CAM_X0302);
                SkinManager.setBackgroundResource(this.f70056g, R.drawable.bg_music_choose);
                SkinManager.setBackgroundColor(this.f70057h, R.color.CAM_X0204);
                SkinManager.setImageResource(this.f70051b, R.drawable.btn_icon_play_video_n);
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface c {
        void A0(View view, String str, int i2);
    }

    public a(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f70046h = "";
        this.f70043e = fVar;
        this.f70044f = new ArrayList();
    }

    public void b(List<CloudMusicData.MusicTagList.MusicList> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null) {
            return;
        }
        for (CloudMusicData.MusicTagList.MusicList musicList : list) {
            if (!this.f70044f.contains(musicList)) {
                this.f70044f.add(musicList);
            }
        }
        notifyDataSetChanged();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public CloudMusicData.MusicTagList.MusicList getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? this.f70044f.get(i2) : (CloudMusicData.MusicTagList.MusicList) invokeI.objValue;
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f70046h = str;
        }
    }

    public void e(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            this.f70045g = cVar;
        }
    }

    public void f(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            getItem(i2).isLoading = z;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f70044f.size() : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                view = LayoutInflater.from(this.f70043e.getPageActivity()).inflate(R.layout.cloud_music_item, viewGroup, false);
                bVar = new b();
                bVar.f70051b = (TbImageView) view.findViewById(R.id.music_state);
                TbImageView tbImageView = (TbImageView) view.findViewById(R.id.music_image);
                bVar.f70050a = tbImageView;
                tbImageView.setDrawerType(1);
                bVar.f70050a.setIsRound(true);
                bVar.f70050a.setDefaultResource(R.drawable.bg_video_cloudmusic);
                bVar.f70050a.setDefaultBgResource(R.color.transparent);
                bVar.f70050a.setBorderWidth(l.g(this.f70043e.getPageActivity(), R.dimen.ds4));
                bVar.f70050a.setBorderColor(SkinManager.getColor(R.color.CAM_X0302));
                bVar.f70050a.setConrers(15);
                bVar.f70052c = view.findViewById(R.id.music_loading);
                bVar.f70053d = (TextView) view.findViewById(R.id.music_title);
                bVar.f70054e = (TextView) view.findViewById(R.id.music_author_name);
                bVar.f70055f = (TextView) view.findViewById(R.id.music_duration);
                bVar.f70056g = (TextView) view.findViewById(R.id.music_choose);
                bVar.f70057h = view.findViewById(R.id.line);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            bVar.b(TbadkCoreApplication.getInst().getSkinType());
            CloudMusicData.MusicTagList.MusicList musicList = this.f70044f.get(i2);
            if (musicList != null) {
                bVar.f70053d.setText(musicList.name);
                bVar.f70050a.M(musicList.image, 10, false);
                bVar.f70054e.setText(musicList.author);
                bVar.f70055f.setText(StringHelper.stringForVideoTime(musicList.duration * 1000));
                if (musicList.isLoading) {
                    bVar.f70052c.setVisibility(0);
                } else {
                    bVar.f70052c.setVisibility(4);
                }
                if (musicList.equals(d.a.s0.z3.l.i.a.b().a())) {
                    bVar.f70051b.setImageResource(R.drawable.btn_icon_stop_video);
                    bVar.f70050a.setDrawBorder(true);
                    bVar.f70056g.setVisibility(0);
                    bVar.f70052c.setVisibility(4);
                    musicList.isLoading = false;
                    bVar.f70056g.setOnClickListener(new View$OnClickListenerC1918a(this, musicList, i2));
                } else if (d.a.s0.z3.l.i.a.b().a() == null && getItem(i2) != null && !TextUtils.isEmpty(this.f70046h) && this.f70046h.equals(String.valueOf(getItem(i2).music_id))) {
                    bVar.f70051b.setImageResource(R.drawable.btn_icon_play_video_n);
                    bVar.f70050a.setDrawBorder(true);
                    bVar.f70056g.setVisibility(8);
                    bVar.f70052c.setVisibility(4);
                    musicList.isLoading = false;
                } else {
                    bVar.f70051b.setImageResource(R.drawable.btn_icon_play_video_n);
                    bVar.f70050a.setDrawBorder(false);
                    bVar.f70056g.setVisibility(8);
                }
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
