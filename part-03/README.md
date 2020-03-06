# Part 3 - Image components and animation effects
## Unit 16 - Image Button adn Image View
(1) ImageButton 的影像資料，必須放在 app/res/drawable 的資料夾內。

## Unit 17 - ImageSwitcher and GridView
(1) 新增 ImageAdapter 來管理影像陣列，並提供 GridView 使用。
(2) ImageAdapter 類別中 getCount() , getItem() ...等 callback function，是 Android 系統在執行 app 的過程中，透過 callback function 互動、完成該執行的事項。
(3) 在 Main Activity 必須加入 implements ViewSwitcher.ViewFactory 影像正常顯示。