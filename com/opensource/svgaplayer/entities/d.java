package com.opensource.svgaplayer.entities;

import com.opensource.svgaplayer.proto.ShapeEntity;
import kotlin.h;
@h
/* loaded from: classes.dex */
public final /* synthetic */ class d {
    public static final /* synthetic */ int[] nmf = new int[ShapeEntity.ShapeType.values().length];
    public static final /* synthetic */ int[] nmg;
    public static final /* synthetic */ int[] nmh;

    static {
        nmf[ShapeEntity.ShapeType.SHAPE.ordinal()] = 1;
        nmf[ShapeEntity.ShapeType.RECT.ordinal()] = 2;
        nmf[ShapeEntity.ShapeType.ELLIPSE.ordinal()] = 3;
        nmf[ShapeEntity.ShapeType.KEEP.ordinal()] = 4;
        nmg = new int[ShapeEntity.ShapeStyle.LineCap.values().length];
        nmg[ShapeEntity.ShapeStyle.LineCap.LineCap_BUTT.ordinal()] = 1;
        nmg[ShapeEntity.ShapeStyle.LineCap.LineCap_ROUND.ordinal()] = 2;
        nmg[ShapeEntity.ShapeStyle.LineCap.LineCap_SQUARE.ordinal()] = 3;
        nmh = new int[ShapeEntity.ShapeStyle.LineJoin.values().length];
        nmh[ShapeEntity.ShapeStyle.LineJoin.LineJoin_BEVEL.ordinal()] = 1;
        nmh[ShapeEntity.ShapeStyle.LineJoin.LineJoin_MITER.ordinal()] = 2;
        nmh[ShapeEntity.ShapeStyle.LineJoin.LineJoin_ROUND.ordinal()] = 3;
    }
}
