package com.meizu.cloud.pushsdk.handler.a.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g implements Parcelable {
    public static final Parcelable.Creator<g> CREATOR = new Parcelable.Creator<g>() { // from class: com.meizu.cloud.pushsdk.handler.a.b.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public g createFromParcel(Parcel parcel) {
            return new g(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public g[] newArray(int i2) {
            return new g[i2];
        }
    };
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f58836b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f58837c;

    /* renamed from: d  reason: collision with root package name */
    public b f58838d;

    /* renamed from: e  reason: collision with root package name */
    public String f58839e;

    public g(Parcel parcel) {
        this.a = parcel.readInt();
        this.f58836b = parcel.readByte() != 0;
        this.f58837c = parcel.createStringArrayList();
        this.f58838d = (b) parcel.readParcelable(b.class.getClassLoader());
        this.f58839e = parcel.readString();
    }

    public g(String str, String str2, String str3, String str4) {
        this.f58839e = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.isNull(TiebaPrepareImageService.MAX_SIZE)) {
                this.a = jSONObject.getInt(TiebaPrepareImageService.MAX_SIZE);
            }
            if (!jSONObject.isNull("wifi_upload")) {
                this.f58836b = jSONObject.getBoolean("wifi_upload");
            }
            if (!jSONObject.isNull("upload_files")) {
                JSONArray jSONArray = jSONObject.getJSONArray("upload_files");
                this.f58837c = new ArrayList();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    this.f58837c.add(jSONArray.getString(i2));
                }
            }
        } catch (JSONException e2) {
            c.k.a.a.a.b("UploadLogMessage", "parse upload message error " + e2.getMessage());
        }
        this.f58838d = new b(str2, str3, str4);
    }

    public int a() {
        return this.a;
    }

    public boolean b() {
        return this.f58836b;
    }

    public List<String> c() {
        return this.f58837c;
    }

    public b d() {
        return this.f58838d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "UploadLogMessage{maxSize=" + this.a + ", wifiUpload=" + this.f58836b + ", fileList=" + this.f58837c + ", controlMessage=" + this.f58838d + ", uploadMessage='" + this.f58839e + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.a);
        parcel.writeByte(this.f58836b ? (byte) 1 : (byte) 0);
        parcel.writeStringList(this.f58837c);
        parcel.writeParcelable(this.f58838d, i2);
        parcel.writeString(this.f58839e);
    }
}
