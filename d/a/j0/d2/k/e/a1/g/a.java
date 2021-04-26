package d.a.j0.d2.k.e.a1.g;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<EmotionImageData> f52219e;

    /* renamed from: f  reason: collision with root package name */
    public int f52220f;

    /* renamed from: g  reason: collision with root package name */
    public EmotionView.c f52221g;

    /* renamed from: h  reason: collision with root package name */
    public PbEmotionBar.i f52222h;

    /* renamed from: i  reason: collision with root package name */
    public Set<String> f52223i = new HashSet();

    /* renamed from: d.a.j0.d2.k.e.a1.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1171a implements View.OnClickListener {
        public View$OnClickListenerC1171a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f52222h == null || !(view instanceof EmotionView)) {
                return;
            }
            EmotionView emotionView = (EmotionView) view;
            a.this.f52222h.b(emotionView.getData(), emotionView.getIsGif());
            TiebaStatic.log("c12176");
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f52222h != null) {
                ArrayList arrayList = new ArrayList();
                if (!ListUtils.isEmpty(a.this.f52219e)) {
                    for (EmotionImageData emotionImageData : a.this.f52219e) {
                        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                            arrayList.add(emotionImageData.getThumbUrl());
                        }
                    }
                }
                a.this.f52222h.a(null, null, arrayList);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends BdAsyncTask<Void, Void, Boolean> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(Void... voidArr) {
            if (a.this.f52223i != null) {
                for (String str : a.this.f52223i) {
                    if (!TextUtils.isEmpty(str)) {
                        d.a.i0.a0.c.k().h(str);
                    }
                }
                return Boolean.TRUE;
            }
            return Boolean.TRUE;
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public EmotionView f52227a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f52228b;
    }

    public void d() {
        new c().execute(new Void[0]);
    }

    public void e(List<EmotionImageData> list) {
        this.f52219e = list;
    }

    public void f(EmotionView.c cVar) {
        this.f52221g = cVar;
    }

    public void g(PbEmotionBar.i iVar) {
        this.f52222h = iVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (ListUtils.isEmpty(this.f52219e)) {
            return 0;
        }
        return this.f52219e.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        View view2;
        d dVar;
        if (view == null) {
            dVar = new d();
            view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_pb_emotion_bar, (ViewGroup) null);
            EmotionView emotionView = (EmotionView) view2.findViewById(R.id.iv_emotion);
            dVar.f52227a = emotionView;
            emotionView.A0();
            dVar.f52227a.setController(this.f52221g);
            dVar.f52227a.setOnClickListener(new View$OnClickListenerC1171a());
            TextView textView = (TextView) view2.findViewById(R.id.tv_more);
            dVar.f52228b = textView;
            SkinManager.setViewTextColor(textView, R.color.CAM_X0109);
            dVar.f52228b.setOnClickListener(new b());
            view2.setTag(dVar);
        } else {
            view2 = view;
            dVar = (d) view.getTag();
        }
        if (i2 >= 0) {
            if (i2 < this.f52219e.size()) {
                dVar.f52227a.getLayoutParams().width = this.f52220f;
                dVar.f52227a.getLayoutParams().height = this.f52220f;
                dVar.f52227a.Q();
                dVar.f52227a.setTag(R.id.iv_emotion, null);
                EmotionImageData emotionImageData = this.f52219e.get(i2);
                if (emotionImageData != null) {
                    dVar.f52227a.C0(emotionImageData);
                    if (this.f52223i != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        Set<String> set = this.f52223i;
                        set.add(emotionImageData.getThumbUrl() + dVar.f52227a.getLoadProcType());
                    }
                }
                dVar.f52227a.setVisibility(0);
                dVar.f52228b.setVisibility(8);
            } else if (i2 == this.f52219e.size()) {
                dVar.f52228b.getLayoutParams().width = this.f52220f;
                dVar.f52228b.getLayoutParams().height = this.f52220f;
                dVar.f52227a.setVisibility(8);
                dVar.f52228b.setVisibility(0);
            }
        }
        return view2;
    }

    public void h(int i2) {
        if (this.f52220f != i2) {
            this.f52220f = i2;
            notifyDataSetChanged();
        }
    }
}
