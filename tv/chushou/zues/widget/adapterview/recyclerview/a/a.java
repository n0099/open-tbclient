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
public abstract class a<T> extends RecyclerView.Adapter<View$OnLongClickListenerC1101a> {
    private List<T> data;
    private int pre;
    private d qdW;
    private e qdX;

    public abstract void a(View$OnLongClickListenerC1101a view$OnLongClickListenerC1101a, T t);

    public a(@LayoutRes int i, d dVar) {
        this(null, i, dVar);
    }

    public a(List<T> list, @LayoutRes int i, d dVar) {
        if (list == null) {
            this.data = new ArrayList();
        } else {
            this.data = list;
        }
        this.pre = i;
        this.qdW = dVar;
    }

    public a(List<T> list, @LayoutRes int i, d dVar, e eVar) {
        if (list == null) {
            this.data = new ArrayList();
        } else {
            this.data = list;
        }
        this.pre = i;
        this.qdW = dVar;
        this.qdX = eVar;
    }

    public void gM(List<T> list) {
        this.data.clear();
        if (list != null) {
            this.data.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: R */
    public View$OnLongClickListenerC1101a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new View$OnLongClickListenerC1101a(LayoutInflater.from(viewGroup.getContext()).inflate(Qt(i), viewGroup, false), this.qdW, this.qdX);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int Qt(int i) {
        return this.pre;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(View$OnLongClickListenerC1101a view$OnLongClickListenerC1101a, int i) {
        a(view$OnLongClickListenerC1101a, (View$OnLongClickListenerC1101a) this.data.get(i), i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull View$OnLongClickListenerC1101a view$OnLongClickListenerC1101a, int i, @NonNull List<Object> list) {
        onBindViewHolder(view$OnLongClickListenerC1101a, i);
    }

    public T getItem(int i) {
        if (this.data == null || i >= this.data.size()) {
            return null;
        }
        return this.data.get(i);
    }

    public void a(View$OnLongClickListenerC1101a view$OnLongClickListenerC1101a, T t, int i) {
        a(view$OnLongClickListenerC1101a, (View$OnLongClickListenerC1101a) t);
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
    public static class View$OnLongClickListenerC1101a extends RecyclerView.ViewHolder implements View.OnLongClickListener {
        private final View.OnClickListener mOnClickListener;
        private SparseArray<View> pro;
        private d qdW;
        private e qdX;

        public View$OnLongClickListenerC1101a(View view, d dVar, e eVar) {
            super(view);
            this.mOnClickListener = new tv.chushou.zues.a() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.a.a.a.1
                @Override // tv.chushou.zues.a
                public void dX(View view2) {
                    if (View$OnLongClickListenerC1101a.this.qdW != null) {
                        View$OnLongClickListenerC1101a.this.qdW.I(view2, View$OnLongClickListenerC1101a.this.getLayoutPosition());
                    }
                }
            };
            this.qdW = dVar;
            this.qdX = eVar;
            this.pro = new SparseArray<>();
            view.setOnClickListener(this.mOnClickListener);
            view.setOnLongClickListener(this);
        }

        public <V extends View> V rW(int i) {
            V v = (V) this.pro.get(i);
            if (v == null) {
                V v2 = (V) this.itemView.findViewById(i);
                this.pro.put(i, v2);
                return v2;
            }
            return v;
        }

        public View$OnLongClickListenerC1101a a(int i, CharSequence charSequence) {
            TextView textView = (TextView) rW(i);
            if (textView != null) {
                textView.setText(charSequence);
            }
            return this;
        }

        public View$OnLongClickListenerC1101a eB(int i, @ColorInt int i2) {
            TextView textView = (TextView) rW(i);
            if (textView != null) {
                textView.setTextColor(i2);
            }
            return this;
        }

        public View$OnLongClickListenerC1101a a(int i, ColorStateList colorStateList) {
            TextView textView = (TextView) rW(i);
            if (textView != null) {
                textView.setTextColor(colorStateList);
            }
            return this;
        }

        public View$OnLongClickListenerC1101a eC(int i, @DrawableRes int i2) {
            ImageView imageView = (ImageView) rW(i);
            if (imageView != null) {
                imageView.setImageResource(i2);
            }
            return this;
        }

        public View$OnLongClickListenerC1101a a(int i, String str, int i2, int i3, int i4) {
            FrescoThumbnailView frescoThumbnailView = (FrescoThumbnailView) rW(i);
            if (frescoThumbnailView != null) {
                frescoThumbnailView.j(str, i2, i3, i4);
            }
            return this;
        }

        public View$OnLongClickListenerC1101a a(int i, String str, int i2, int i3, int i4, int i5, boolean z, boolean z2) {
            FrescoThumbnailView frescoThumbnailView = (FrescoThumbnailView) rW(i);
            if (frescoThumbnailView != null) {
                frescoThumbnailView.setGray(z);
                frescoThumbnailView.setAnim(z2);
                frescoThumbnailView.a(str, i2, i3, i4, i5);
            }
            return this;
        }

        public View$OnLongClickListenerC1101a a(boolean z, int... iArr) {
            for (int i : iArr) {
                View rW = rW(i);
                if (rW != null) {
                    rW.setVisibility(z ? 0 : 8);
                }
            }
            return this;
        }

        public View$OnLongClickListenerC1101a t(int... iArr) {
            for (int i : iArr) {
                View rW = rW(i);
                if (rW != null) {
                    rW.setOnClickListener(this.mOnClickListener);
                }
            }
            return this;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (this.qdX != null) {
                this.qdX.J(view, getLayoutPosition());
                return false;
            }
            return false;
        }
    }
}
