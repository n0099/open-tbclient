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
/* loaded from: classes5.dex */
public abstract class a<T> extends RecyclerView.Adapter<View$OnLongClickListenerC0921a> {
    private List<T> data;
    private d nPc;
    private e nPd;
    private int nbO;

    public abstract void a(View$OnLongClickListenerC0921a view$OnLongClickListenerC0921a, T t);

    public a(@LayoutRes int i, d dVar) {
        this(null, i, dVar);
    }

    public a(List<T> list, @LayoutRes int i, d dVar) {
        if (list == null) {
            this.data = new ArrayList();
        } else {
            this.data = list;
        }
        this.nbO = i;
        this.nPc = dVar;
    }

    public a(List<T> list, @LayoutRes int i, d dVar, e eVar) {
        if (list == null) {
            this.data = new ArrayList();
        } else {
            this.data = list;
        }
        this.nbO = i;
        this.nPc = dVar;
        this.nPd = eVar;
    }

    public void fz(List<T> list) {
        this.data.clear();
        if (list != null) {
            this.data.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: F */
    public View$OnLongClickListenerC0921a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new View$OnLongClickListenerC0921a(LayoutInflater.from(viewGroup.getContext()).inflate(Jm(i), viewGroup, false), this.nPc, this.nPd);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int Jm(int i) {
        return this.nbO;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(View$OnLongClickListenerC0921a view$OnLongClickListenerC0921a, int i) {
        a(view$OnLongClickListenerC0921a, (View$OnLongClickListenerC0921a) this.data.get(i), i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull View$OnLongClickListenerC0921a view$OnLongClickListenerC0921a, int i, @NonNull List<Object> list) {
        onBindViewHolder(view$OnLongClickListenerC0921a, i);
    }

    public T getItem(int i) {
        if (this.data == null || i >= this.data.size()) {
            return null;
        }
        return this.data.get(i);
    }

    public void a(View$OnLongClickListenerC0921a view$OnLongClickListenerC0921a, T t, int i) {
        a(view$OnLongClickListenerC0921a, (View$OnLongClickListenerC0921a) t);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.data == null) {
            return 0;
        }
        return this.data.size();
    }

    /* renamed from: tv.chushou.zues.widget.adapterview.recyclerview.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class View$OnLongClickListenerC0921a extends RecyclerView.ViewHolder implements View.OnLongClickListener {
        private final View.OnClickListener mOnClickListener;
        private d nPc;
        private e nPd;
        private SparseArray<View> nbY;

        public View$OnLongClickListenerC0921a(View view, d dVar, e eVar) {
            super(view);
            this.mOnClickListener = new tv.chushou.zues.a() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.a.a.a.1
                @Override // tv.chushou.zues.a
                public void dr(View view2) {
                    if (View$OnLongClickListenerC0921a.this.nPc != null) {
                        View$OnLongClickListenerC0921a.this.nPc.B(view2, View$OnLongClickListenerC0921a.this.getLayoutPosition());
                    }
                }
            };
            this.nPc = dVar;
            this.nPd = eVar;
            this.nbY = new SparseArray<>();
            view.setOnClickListener(this.mOnClickListener);
            view.setOnLongClickListener(this);
        }

        public <V extends View> V KD(int i) {
            V v = (V) this.nbY.get(i);
            if (v == null) {
                V v2 = (V) this.itemView.findViewById(i);
                this.nbY.put(i, v2);
                return v2;
            }
            return v;
        }

        public View$OnLongClickListenerC0921a a(int i, CharSequence charSequence) {
            TextView textView = (TextView) KD(i);
            if (textView != null) {
                textView.setText(charSequence);
            }
            return this;
        }

        public View$OnLongClickListenerC0921a dW(int i, @ColorInt int i2) {
            TextView textView = (TextView) KD(i);
            if (textView != null) {
                textView.setTextColor(i2);
            }
            return this;
        }

        public View$OnLongClickListenerC0921a a(int i, ColorStateList colorStateList) {
            TextView textView = (TextView) KD(i);
            if (textView != null) {
                textView.setTextColor(colorStateList);
            }
            return this;
        }

        public View$OnLongClickListenerC0921a dX(int i, @DrawableRes int i2) {
            ImageView imageView = (ImageView) KD(i);
            if (imageView != null) {
                imageView.setImageResource(i2);
            }
            return this;
        }

        public View$OnLongClickListenerC0921a a(int i, String str, int i2, int i3, int i4) {
            FrescoThumbnailView frescoThumbnailView = (FrescoThumbnailView) KD(i);
            if (frescoThumbnailView != null) {
                frescoThumbnailView.i(str, i2, i3, i4);
            }
            return this;
        }

        public View$OnLongClickListenerC0921a a(int i, String str, int i2, int i3, int i4, int i5, boolean z, boolean z2) {
            FrescoThumbnailView frescoThumbnailView = (FrescoThumbnailView) KD(i);
            if (frescoThumbnailView != null) {
                frescoThumbnailView.setGray(z);
                frescoThumbnailView.setAnim(z2);
                frescoThumbnailView.a(str, i2, i3, i4, i5);
            }
            return this;
        }

        public View$OnLongClickListenerC0921a a(boolean z, int... iArr) {
            for (int i : iArr) {
                View KD = KD(i);
                if (KD != null) {
                    KD.setVisibility(z ? 0 : 8);
                }
            }
            return this;
        }

        public View$OnLongClickListenerC0921a t(int... iArr) {
            for (int i : iArr) {
                View KD = KD(i);
                if (KD != null) {
                    KD.setOnClickListener(this.mOnClickListener);
                }
            }
            return this;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (this.nPd != null) {
                this.nPd.C(view, getLayoutPosition());
                return false;
            }
            return false;
        }
    }
}
