package com.sina.weibo.sdk.register.mobile;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.sina.weibo.sdk.component.view.TitleBar;
import com.sina.weibo.sdk.register.mobile.LetterIndexBar;
import com.sina.weibo.sdk.utils.ResourceManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes3.dex */
public class SelectCountryActivity extends Activity implements LetterIndexBar.OnIndexChangeListener {
    private static final String CHINA_CN = "中国";
    private static final String CHINA_EN = "China";
    private static final String CHINA_TW = "中國";
    public static final String EXTRA_COUNTRY_CODE = "code";
    public static final String EXTRA_COUNTRY_NAME = "name";
    private static final String INFO_CN = "常用";
    private static final String INFO_EN = "Common";
    private static final String INFO_TW = "常用";
    private static final String SELECT_COUNTRY_EN = "Region";
    private static final String SELECT_COUNTRY_ZH_CN = "选择国家";
    private static final String SELECT_COUNTRY_ZH_TW = "選擇國家";
    private List<Country>[] arrSubCountry;
    String countryStr = "";
    private List<IndexCountry> indexCountries = new ArrayList();
    private CountryAdapter mAdapter;
    private List<Country> mCountries;
    private FrameLayout mFrameLayout;
    private LetterIndexBar mLetterIndexBar;
    private ListView mListView;
    private RelativeLayout mMainLayout;
    private CountryList result;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    private void initView() {
        this.mMainLayout = new RelativeLayout(this);
        this.mMainLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        TitleBar titleBar = new TitleBar(this);
        titleBar.setId(1);
        titleBar.setLeftBtnBg(ResourceManager.createStateListDrawable(this, "weibosdk_navigationbar_back.png", "weibosdk_navigationbar_back_highlighted.png"));
        titleBar.setTitleBarText(ResourceManager.getString(this, SELECT_COUNTRY_EN, SELECT_COUNTRY_ZH_CN, SELECT_COUNTRY_ZH_TW));
        titleBar.setTitleBarClickListener(new TitleBar.ListenerOnTitleBtnClicked() { // from class: com.sina.weibo.sdk.register.mobile.SelectCountryActivity.1
            @Override // com.sina.weibo.sdk.component.view.TitleBar.ListenerOnTitleBtnClicked
            public void onLeftBtnClicked() {
                SelectCountryActivity.this.setResult(0);
                SelectCountryActivity.this.finish();
            }
        });
        this.mMainLayout.addView(titleBar);
        this.mFrameLayout = new FrameLayout(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(3, titleBar.getId());
        this.mFrameLayout.setLayoutParams(layoutParams);
        this.mMainLayout.addView(this.mFrameLayout);
        this.mListView = new ListView(this);
        this.mListView.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.mListView.setFadingEdgeLength(0);
        this.mListView.setSelector(new ColorDrawable(0));
        this.mListView.setDividerHeight(ResourceManager.dp2px(this, 1));
        this.mListView.setCacheColorHint(0);
        this.mListView.setDrawSelectorOnTop(false);
        this.mListView.setScrollingCacheEnabled(false);
        this.mListView.setScrollbarFadingEnabled(false);
        this.mListView.setVerticalScrollBarEnabled(false);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.sina.weibo.sdk.register.mobile.SelectCountryActivity.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                Country country = (Country) SelectCountryActivity.this.mAdapter.getItem(i);
                if (country != null) {
                    Intent intent = new Intent();
                    intent.putExtra("code", country.getCode());
                    intent.putExtra("name", country.getName());
                    SelectCountryActivity.this.setResult(-1, intent);
                    SelectCountryActivity.this.finish();
                }
            }
        });
        this.mFrameLayout.addView(this.mListView);
        this.mAdapter = new CountryAdapter(this, null);
        this.mListView.setAdapter((ListAdapter) this.mAdapter);
        this.mLetterIndexBar = new LetterIndexBar(this);
        this.mLetterIndexBar.setIndexChangeListener(this);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -1);
        layoutParams2.gravity = 5;
        this.mLetterIndexBar.setLayoutParams(layoutParams2);
        this.mFrameLayout.addView(this.mLetterIndexBar);
        PinyinUtils.getInstance(this);
        Locale language = ResourceManager.getLanguage();
        if (Locale.SIMPLIFIED_CHINESE.equals(language)) {
            this.countryStr = ResourceManager.readCountryFromAsset(this, "countryCode.txt");
        } else if (Locale.TRADITIONAL_CHINESE.equals(language)) {
            this.countryStr = ResourceManager.readCountryFromAsset(this, "countryCodeTw.txt");
        } else {
            this.countryStr = ResourceManager.readCountryFromAsset(this, "countryCodeEn.txt");
        }
        this.result = new CountryList(this.countryStr);
        this.mCountries = this.result.countries;
        this.arrSubCountry = subCountries(this.mCountries);
        this.indexCountries = compose(this.arrSubCountry);
        this.mAdapter.notifyDataSetChanged();
        setContentView(this.mMainLayout);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // com.sina.weibo.sdk.register.mobile.LetterIndexBar.OnIndexChangeListener
    public void onIndexChange(int i) {
        if (this.arrSubCountry != null && i < this.arrSubCountry.length && this.arrSubCountry[i] != null) {
            this.mListView.setSelection(this.indexCountries.indexOf(new IndexCountry(i, -1)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class IndexCountry {
        int indexInList;
        int indexInListArray;

        IndexCountry(int i, int i2) {
            this.indexInListArray = i;
            this.indexInList = i2;
        }

        public boolean equals(Object obj) {
            if ((obj instanceof IndexCountry) && this.indexInList == -1) {
                IndexCountry indexCountry = (IndexCountry) obj;
                return this.indexInListArray == indexCountry.indexInListArray && this.indexInList == indexCountry.indexInList;
            }
            return false;
        }
    }

    private List<Country>[] subCountries(List<Country> list) {
        ArrayList[] arrayListArr = new ArrayList[27];
        Country country = new Country();
        country.setCode(Country.CHINA_CODE);
        country.setName(ResourceManager.getString(this, CHINA_EN, CHINA_CN, CHINA_TW));
        arrayListArr[0] = new ArrayList();
        arrayListArr[0].add(country);
        for (int i = 0; i < list.size(); i++) {
            Country country2 = list.get(i);
            if (country2.getCode().equals("00852") || country2.getCode().equals("00853") || country2.getCode().equals("00886")) {
                arrayListArr[0].add(country2);
            } else {
                int charAt = (country2.getPinyin().charAt(0) - 'a') + 1;
                if (arrayListArr[charAt] == null) {
                    arrayListArr[charAt] = new ArrayList();
                }
                arrayListArr[charAt].add(country2);
            }
        }
        return arrayListArr;
    }

    private List<IndexCountry> compose(List<Country>[] listArr) {
        ArrayList arrayList = new ArrayList();
        if (listArr != null) {
            for (int i = 0; i < listArr.length; i++) {
                List<Country> list = listArr[i];
                if (list != null && list.size() > 0) {
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        if (i2 == 0) {
                            arrayList.add(new IndexCountry(i, -1));
                        }
                        arrayList.add(new IndexCountry(i, i2));
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class CountryAdapter extends BaseAdapter {
        private CountryAdapter() {
        }

        /* synthetic */ CountryAdapter(SelectCountryActivity selectCountryActivity, CountryAdapter countryAdapter) {
            this();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (SelectCountryActivity.this.indexCountries != null) {
                return SelectCountryActivity.this.indexCountries.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            if (SelectCountryActivity.this.indexCountries == null || SelectCountryActivity.this.indexCountries.isEmpty()) {
                return null;
            }
            if (i == SelectCountryActivity.this.indexCountries.size()) {
                return null;
            }
            IndexCountry indexCountry = (IndexCountry) SelectCountryActivity.this.indexCountries.get(i);
            if (indexCountry.indexInList == -1) {
                return null;
            }
            return SelectCountryActivity.this.arrSubCountry[indexCountry.indexInListArray].get(indexCountry.indexInList);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return 0L;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view2, ViewGroup viewGroup) {
            IndexCountry indexCountry = (IndexCountry) SelectCountryActivity.this.indexCountries.get(i);
            if (view2 == null) {
                if (indexCountry.indexInList != -1) {
                    Country country = (Country) SelectCountryActivity.this.arrSubCountry[indexCountry.indexInListArray].get(indexCountry.indexInList);
                    return new SelectCountryItemView(SelectCountryActivity.this, country.getName(), country.getCode());
                }
                return createTitleView(indexCountry.indexInListArray);
            } else if (indexCountry.indexInList != -1) {
                Country country2 = (Country) SelectCountryActivity.this.arrSubCountry[indexCountry.indexInListArray].get(indexCountry.indexInList);
                if (view2 instanceof SelectCountryTitleView) {
                    return new SelectCountryItemView(SelectCountryActivity.this, country2.getName(), country2.getCode());
                }
                ((SelectCountryItemView) view2).updateContent(country2.getName(), country2.getCode());
                return view2;
            } else if (view2 instanceof SelectCountryTitleView) {
                if (indexCountry.indexInListArray == 0) {
                    ((SelectCountryTitleView) view2).update(ResourceManager.getString(SelectCountryActivity.this, SelectCountryActivity.INFO_EN, "常用", "常用"));
                    return view2;
                }
                return createTitleView(indexCountry.indexInListArray);
            } else {
                return createTitleView(indexCountry.indexInListArray);
            }
        }

        private SelectCountryTitleView createTitleView(int i) {
            SelectCountryTitleView selectCountryTitleView = new SelectCountryTitleView(SelectCountryActivity.this.getApplicationContext());
            if (i == 0) {
                selectCountryTitleView.setTitle(ResourceManager.getString(SelectCountryActivity.this, SelectCountryActivity.INFO_EN, "常用", "常用"));
            } else {
                selectCountryTitleView.setTitle(String.valueOf((char) ((i + 65) - 1)));
            }
            return selectCountryTitleView;
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }
}
