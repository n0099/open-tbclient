package tv.chushou.zues.widget.adapterview.recyclerview.a;

import android.content.res.ColorStateList;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import tv.chushou.zues.widget.adapterview.d;
import tv.chushou.zues.widget.adapterview.e;
import tv.chushou.zues.widget.fresco.FrescoThumbnailView;
/* loaded from: classes6.dex */
public abstract class a<T> extends RecyclerView.Adapter<View$OnLongClickListenerC0956a> {
    private List<T> data;
    private int nGr;
    private e otA;
    private d otz;

    public abstract void a(View$OnLongClickListenerC0956a view$OnLongClickListenerC0956a, T t);

    public a(@LayoutRes int i, d dVar) {
        this(null, i, dVar);
    }

    public a(List<T> list, @LayoutRes int i, d dVar) {
        if (list == null) {
            this.data = new ArrayList();
        } else {
            this.data = list;
        }
        this.nGr = i;
        this.otz = dVar;
    }

    public a(List<T> list, @LayoutRes int i, d dVar, e eVar) {
        if (list == null) {
            this.data = new ArrayList();
        } else {
            this.data = list;
        }
        this.nGr = i;
        this.otz = dVar;
        this.otA = eVar;
    }

    public void fU(List<T> list) {
        this.data.clear();
        if (list != null) {
            this.data.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: L */
    public View$OnLongClickListenerC0956a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new View$OnLongClickListenerC0956a(LayoutInflater.from(viewGroup.getContext()).inflate(KN(i), viewGroup, false), this.otz, this.otA);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int KN(int i) {
        return this.nGr;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(View$OnLongClickListenerC0956a view$OnLongClickListenerC0956a, int i) {
        a(view$OnLongClickListenerC0956a, (View$OnLongClickListenerC0956a) this.data.get(i), i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull View$OnLongClickListenerC0956a view$OnLongClickListenerC0956a, int i, @NonNull List<Object> list) {
        onBindViewHolder(view$OnLongClickListenerC0956a, i);
    }

    public T getItem(int i) {
        if (this.data == null || i >= this.data.size()) {
            return null;
        }
        return this.data.get(i);
    }

    public void a(View$OnLongClickListenerC0956a view$OnLongClickListenerC0956a, T t, int i) {
        a(view$OnLongClickListenerC0956a, (View$OnLongClickListenerC0956a) t);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.data == null) {
            return 0;
        }
        return this.data.size();
    }

    /* renamed from: tv.chushou.zues.widget.adapterview.recyclerview.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class View$OnLongClickListenerC0956a extends RecyclerView.ViewHolder implements View.OnLongClickListener {
        private final View.OnClickListener mOnClickListener;
        private SparseArray<View> nGB;
        private e otA;
        private d otz;

        public View$OnLongClickListenerC0956a(View view, d dVar, e eVar) {
            super(view);
            this.mOnClickListener = new tv.chushou.zues.a() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.a.a.a.1
                @Override // tv.chushou.zues.a
                public void dy(View view2) {
                    if (View$OnLongClickListenerC0956a.this.otz != null) {
                        View$OnLongClickListenerC0956a.this.otz.C(view2, View$OnLongClickListenerC0956a.this.getLayoutPosition());
                    }
                }
            };
            this.otz = dVar;
            this.otA = eVar;
            this.nGB = new SparseArray<>();
            view.setOnClickListener(this.mOnClickListener);
            view.setOnLongClickListener(this);
        }

        public <V extends View> V oK(int i) {
            V v = (V) this.nGB.get(i);
            if (v == null) {
                V v2 = (V) this.itemView.findViewById(i);
                this.nGB.put(i, v2);
                return v2;
            }
            return v;
        }

        public View$OnLongClickListenerC0956a a(int i, CharSequence charSequence) {
            TextView textView = (TextView) oK(i);
            if (textView != null) {
                textView.setText(charSequence);
            }
            return this;
        }

        public View$OnLongClickListenerC0956a eh(int i, @ColorInt int i2) {
            TextView textView = (TextView) oK(i);
            if (textView != null) {
                textView.setTextColor(i2);
            }
            return this;
        }

        public View$OnLongClickListenerC0956a a(int i, ColorStateList colorStateList) {
            TextView textView = (TextView) oK(i);
            if (textView != null) {
                textView.setTextColor(colorStateList);
            }
            return this;
        }

        public View$OnLongClickListenerC0956a ei(int i, @DrawableRes int i2) {
            ImageView imageView = (ImageView) oK(i);
            if (imageView != null) {
                imageView.setImageResource(i2);
            }
            return this;
        }

        public View$OnLongClickListenerC0956a a(int i, String str, int i2, int i3, int i4) {
            FrescoThumbnailView frescoThumbnailView = (FrescoThumbnailView) oK(i);
            if (frescoThumbnailView != null) {
                frescoThumbnailView.i(str, i2, i3, i4);
            }
            return this;
        }

        public View$OnLongClickListenerC0956a a(int i, String str, int i2, int i3, int i4, int i5, boolean z, boolean z2) {
            FrescoThumbnailView frescoThumbnailView = (FrescoThumbnailView) oK(i);
            if (frescoThumbnailView != null) {
                frescoThumbnailView.setGray(z);
                frescoThumbnailView.setAnim(z2);
                frescoThumbnailView.a(str, i2, i3, i4, i5);
            }
            return this;
        }

        public View$OnLongClickListenerC0956a a(boolean z, int... iArr) {
            for (int i : iArr) {
                View oK = oK(i);
                if (oK != null) {
                    oK.setVisibility(z ? 0 : 8);
                }
            }
            return this;
        }

        public View$OnLongClickListenerC0956a t(int... iArr) {
            for (int i : iArr) {
                View oK = oK(i);
                if (oK != null) {
                    oK.setOnClickListener(this.mOnClickListener);
                }
            }
            return this;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (this.otA != null) {
                this.otA.D(view, getLayoutPosition());
                return false;
            }
            return false;
        }
    }
}
